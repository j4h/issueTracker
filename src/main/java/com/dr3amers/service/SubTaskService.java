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

        //fake code won't be released
        subTask.setTaskId(taskId);
        return subTaskJpaRepository.saveAndFlush(subTask);
    }

    public SubTask update(int projectId, int taskId, int id, SubTask subTask) {
        Helper.getSubTaskByIdFromTask(projectJpaRepository, projectId, taskId, id);

        //fake code won't be released
        subTask.setTaskId(taskId);
        return subTaskJpaRepository.saveAndFlush(subTask);
    }



}
