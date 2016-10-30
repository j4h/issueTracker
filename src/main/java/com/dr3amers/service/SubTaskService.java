package com.dr3amers.service;

import com.dr3amers.exception.NotFoundException;
import com.dr3amers.model.SubTask;
import com.dr3amers.repository.SubTaskJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTaskService {

    private SubTaskJpaRepository subTaskJpaRepository;

    @Autowired
    public SubTaskService(SubTaskJpaRepository subTaskJpaRepository) {
        this.subTaskJpaRepository = subTaskJpaRepository;
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

}
