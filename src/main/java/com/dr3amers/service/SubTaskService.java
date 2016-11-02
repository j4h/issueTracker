package com.dr3amers.service;

import com.dr3amers.exception.NotFoundException;
import com.dr3amers.model.SubTask;
import com.dr3amers.repository.SubTaskJpaRepository;
import com.dr3amers.repository.TaskJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTaskService {

    private SubTaskJpaRepository subTaskJpaRepository;
    private TaskJpaRepository taskJpaRepository;

    @Autowired
    public SubTaskService(SubTaskJpaRepository subTaskJpaRepository, TaskJpaRepository taskJpaRepository) {
        this.subTaskJpaRepository = subTaskJpaRepository;
        this.taskJpaRepository = taskJpaRepository;
    }

    public List<SubTask> getAll() {
        return subTaskJpaRepository.findAll();
    }

    public SubTask get(int id) {
        SubTask subTask = subTaskJpaRepository.findOne(id);
        if (subTask == null) {
            throw new NotFoundException(id);
        }
        return subTask;
    }

    public void delete(int projectId, int taskId, int id) {

        get(id);
        subTaskJpaRepository.delete(id);
    }

}
