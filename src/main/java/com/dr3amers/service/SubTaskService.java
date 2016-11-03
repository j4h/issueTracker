package com.dr3amers.service;

import com.dr3amers.exception.NotFoundException;
import com.dr3amers.helper.Helper;
import com.dr3amers.model.Project;
import com.dr3amers.model.SubTask;
import com.dr3amers.model.Task;
import com.dr3amers.repository.ProjectJpaRepository;
import com.dr3amers.repository.SubTaskJpaRepository;
import com.dr3amers.repository.TaskJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTaskService {

    private SubTaskJpaRepository subTaskJpaRepository;
    private TaskJpaRepository taskJpaRepository;
    private ProjectJpaRepository projectJpaRepository;

    @Autowired
    public SubTaskService(SubTaskJpaRepository subTaskJpaRepository, TaskJpaRepository taskJpaRepository,
                          ProjectJpaRepository projectJpaRepository) {
        this.subTaskJpaRepository = subTaskJpaRepository;
        this.taskJpaRepository = taskJpaRepository;
        this.projectJpaRepository = projectJpaRepository;
    }

    public List<SubTask> getAll(int projectId, int taskId) {
        getProjectById(projectId);
        Task task = getTaskById(taskId);
        return task.getSubTaskList();
    }

    public SubTask get(int projectId, int taskId, int id) {
        getProjectById(projectId);
        getTaskById(taskId);
        SubTask subTask = subTaskJpaRepository.findOne(id);
        if (subTask == null) {
            throw new NotFoundException(id);
        }
        return subTask;
    }

    public void delete(int projectId, int taskId, int id) {
        get(projectId,taskId,id);
        subTaskJpaRepository.delete(id);
    }

    public SubTask create(int projectId, int taskId, SubTask subTask) {
        Project project = getProjectById(projectId);
        getTaskById(taskId);
        //set creation_time in the object model
        subTask.setCreation_date(Helper.setCurrentTimestamp());
        //set projectId
        subTask.setTaskId(taskId);
        return subTaskJpaRepository.saveAndFlush(subTask);
    }

    public SubTask update(int projectId, int taskId, int id, SubTask subTask) {
        get(projectId,taskId,id);

        return subTaskJpaRepository.saveAndFlush(subTask);
    }

    private Project getProjectById(int id) {
        Project project = projectJpaRepository.findOne(id);
        if (project == null) {
            throw new NotFoundException(id);
        }
        return project;
    }

    private Task getTaskById(int id) {
        Task task = taskJpaRepository.findOne(id);
        if (task == null) {
            throw new NotFoundException(id);
        }
        return task;
    }

    private Task getTaskByIdFromProject(int projectId, int id) {
        List<Task> tasks = projectJpaRepository.findOne(projectId).getTasks();
        for (Task task:tasks) {
            if (task.getId() == id){
                return task;
            }
        }
        throw new NotFoundException(id);
    }

}
