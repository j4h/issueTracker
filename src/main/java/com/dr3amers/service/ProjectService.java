package com.dr3amers.service;

import com.dr3amers.exception.NotFoundException;
import com.dr3amers.model.Project;
import com.dr3amers.repository.ProjectJpaRepository;
import com.dr3amers.service.helper.ProjectServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectJpaRepository projectJpaRepository;
    private ProjectServiceHelper projectServiceHelper;

    @Autowired
    public ProjectService(ProjectJpaRepository projectJpaRepository, ProjectServiceHelper projectServiceHelper) {
        this.projectJpaRepository = projectJpaRepository;
        this.projectServiceHelper = projectServiceHelper;
    }

    public Project create(Project project) {
        //set creation_time in the object model
        project.setCreation_date(projectServiceHelper.setCurrentTimestamp());
        return projectJpaRepository.saveAndFlush(project);
    }

    public Project update(int id, Project project) {
        get(id);
        project.setId(id);
        return projectJpaRepository.saveAndFlush(project);
    }

    public Project get(int id) {
        Project project = projectJpaRepository.findOne(id);
        if (project == null) {
            throw new NotFoundException(id);
        }
        return projectJpaRepository.findOne(id);
    }

    public void delete(int id) {
        Project project = get(id);
        projectJpaRepository.delete(project);
    }

    public List<Project> getAll() {
        return projectJpaRepository.findAll();
    }
}
