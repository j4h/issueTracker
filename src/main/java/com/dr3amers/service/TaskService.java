package com.dr3amers.service;

import com.dr3amers.helper.Helper;
import com.dr3amers.validator.CrudAccessValidator;
import com.dr3amers.validator.StatusUpdatesValidator;
import com.dr3amers.model.Task;
import com.dr3amers.repository.ProjectJpaRepository;
import com.dr3amers.repository.TaskJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskJpaRepository taskJpaRepository;
    private final ProjectJpaRepository projectJpaRepository;

    @Autowired
    public TaskService(TaskJpaRepository taskJpaRepository, ProjectJpaRepository projectJpaRepository) {
        this.taskJpaRepository = taskJpaRepository;
        this.projectJpaRepository = projectJpaRepository;
    }

    public List<Task> getAll(int projectId) {
        //validation if the project exists and we can access it
        Helper.getProjectById(projectJpaRepository,projectId);
        List<Task> tasks = taskJpaRepository.findByProjectId(projectId);
        tasks.removeIf(task -> task.getAssigneeId() != Helper.getCurrentUser().getId());
        return tasks;
    }

    public Task get(int projectId, int taskId) {
        return Helper.getTaskById(projectJpaRepository, taskJpaRepository, projectId, taskId);
    }

    //actually, we aren't delete any data, just hide it
    public void delete(int projectId, int taskId) {
        Task task = get(projectId, taskId);
        CrudAccessValidator.modelUpdateValidation(task, task.getCreatorId());
        setAllBoundEntitiesDeleted(task);
        taskJpaRepository.saveAndFlush(task);
    }

    public Task create(int projectId, Task task) {
        Helper.getProjectById(projectJpaRepository, projectId);
        task.setCreatorId(Helper.getCurrentUser().getId());

        //fake code that won't be released
        task.setProjectId(projectId);
        return taskJpaRepository.saveAndFlush(task);
    }

    public Task update(int projectId, int taskId, Task task) {
        //validation process
        StatusUpdatesValidator.checkTaskStatusUpdateValidity(projectJpaRepository, taskJpaRepository, projectId, taskId, task);

        return taskJpaRepository.saveAndFlush(task);
    }

    private void setAllBoundEntitiesDeleted(Task task) {
        task.setDeleted(true);
        task.getSubTaskList().forEach(subTask -> subTask.setDeleted(true));
    }

}
