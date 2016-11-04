package com.dr3amers.service;

import com.dr3amers.helper.Helper;
import com.dr3amers.model.SubTask;
import com.dr3amers.repository.ProjectJpaRepository;
import com.dr3amers.repository.SubTaskJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTaskService {

    private SubTaskJpaRepository subTaskJpaRepository;
    private ProjectJpaRepository projectJpaRepository;

    @Autowired
    public SubTaskService(SubTaskJpaRepository subTaskJpaRepository, ProjectJpaRepository projectJpaRepository) {
        this.subTaskJpaRepository = subTaskJpaRepository;
        this.projectJpaRepository = projectJpaRepository;
    }

    public List<SubTask> getAll(int projectId, int taskId) {
        return Helper.getTaskByIdFromProject(projectJpaRepository,projectId,taskId).getSubTaskList();
    }

    public SubTask get(int projectId, int taskId, int id) {
        return Helper.getSubTaskByIdFromTask(projectJpaRepository, projectId, taskId, id);
    }

    public void delete(int projectId, int taskId, int id) {
        get(projectId, taskId, id);
        subTaskJpaRepository.delete(id);
    }

    public SubTask create(int projectId, int taskId, SubTask subTask) {
        Helper.getTaskByIdFromProject(projectJpaRepository, projectId, taskId);
        //set creation_time in the object model
        subTask.setCreation_date(Helper.setCurrentTimestamp());
        //set projectId
        subTask.setTaskId(taskId);
        return subTaskJpaRepository.saveAndFlush(subTask);
    }

    public SubTask update(int projectId, int taskId, int id, SubTask subTask) {
        Helper.getSubTaskByIdFromTask(projectJpaRepository, projectId, taskId, id);

        //this code won't be released
        subTask.setId(id);
        subTask.setTaskId(taskId);
        subTask.setModification_date(Helper.setCurrentTimestamp());
        return subTaskJpaRepository.saveAndFlush(subTask);
    }



}
