package com.dr3amers.service;

import com.dr3amers.helper.Helper;
import com.dr3amers.model.Task;
import com.dr3amers.repository.ProjectJpaRepository;
import com.dr3amers.repository.TaskJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskJpaRepository taskJpaRepository;
    private ProjectJpaRepository projectJpaRepository;

    @Autowired
    public TaskService(TaskJpaRepository taskJpaRepository, ProjectJpaRepository projectJpaRepository) {
        this.taskJpaRepository = taskJpaRepository;
        this.projectJpaRepository = projectJpaRepository;
    }

    public List<Task> getAll(int projectId) {
        return Helper.getProjectById(projectJpaRepository,projectId).getTasks();
    }

    public Task get(int projectId, int id) {
        return Helper.getTaskByIdFromProject(projectJpaRepository,projectId,id);
    }

    public void delete(int projectId, int id) {
        Helper.getTaskByIdFromProject(projectJpaRepository, projectId, id);
        taskJpaRepository.delete(id);
    }

    public Task create(int projectId, Task task) {

        //??how can we know that creation comes from current or accessible project
        Helper.getProjectById(projectJpaRepository, projectId);

        //fake code that won't be released
        task.setProjectId(projectId);
        return taskJpaRepository.saveAndFlush(task);
    }

    public Task update(int projectId, int id, Task task) {
        //validation process
        Helper.checkStatusUpdateValidity(projectJpaRepository, projectId, id, task);

        //fake code that won't be released
        task.setProjectId(projectId);
        return taskJpaRepository.saveAndFlush(task);
    }

}
