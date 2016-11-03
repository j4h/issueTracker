package com.dr3amers.service;

import com.dr3amers.exception.NotFoundException;
import com.dr3amers.helper.Helper;
import com.dr3amers.model.Project;
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

    public Task create(int projectId, Task task) {
        getProject(projectId);
        //set creation_time in the object model
        task.setCreation_date(Helper.setCurrentTimestamp());
        //set projectId
        //task.setProjectId(projectId);
        return taskJpaRepository.saveAndFlush(task);
    }

    public Task update(int projectId, int id, Task task) {
        getProject(projectId);
        get(id);
        //task.setId(id);
        //task.setProjectId(projectId);
        task.setCreation_date(Helper.setCurrentTimestamp());
        task.setModification_date(Helper.setCurrentTimestamp());
        return taskJpaRepository.saveAndFlush(task);
    }

    public void delete(int projectId, int id) {
        getProject(projectId);
        get(id);
        taskJpaRepository.delete(id);
    }

    public Task get(int id) {
        Task task = taskJpaRepository.findOne(id);
        if (task == null) {
            throw new NotFoundException(id);
        }
        return task;
    }

    public Project getProject(int id) {
        Project project = projectJpaRepository.findOne(id);
        if (project == null) {
            throw new NotFoundException(id);
        }
        return project;
    }

    public Task getTaskById(int projectId, int id) {
        List<Task> tasks = projectJpaRepository.findOne(projectId).getTasks();
        for (Task task:tasks) {
            if (task.getId() == id){
                return task;
            }
        }
        throw new NotFoundException(id);
    }

    public List<Task> getAll() {
        return taskJpaRepository.findAll();
    }
}
