package com.dr3amers.service;

import com.dr3amers.exception.NotFoundException;
import com.dr3amers.model.Task;
import com.dr3amers.repository.TaskJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskJpaRepository taskJpaRepository;

    @Autowired
    public TaskService(TaskJpaRepository taskJpaRepository) {
        this.taskJpaRepository = taskJpaRepository;
    }

    public Task get(int id) {
        Task task = taskJpaRepository.findOne(id);
        if (task == null) {
            throw new NotFoundException(id);
        }
        return taskJpaRepository.findOne(id);
    }

    public List<Task> getAll() {
        return taskJpaRepository.findAll();
    }
}
