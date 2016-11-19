package com.dr3amers.service;

import com.dr3amers.exception.NotFoundException;
import com.dr3amers.helper.Helper;
import com.dr3amers.model.AuthenticatedUser;
import com.dr3amers.model.Project;
import com.dr3amers.model.User;
import com.dr3amers.repository.ProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProjectService {

    //SHOULD WE MAKE REPOSITORIES FINAL?
    @Autowired
    private ProjectJpaRepository projectJpaRepository;

    public Project create(Project project) {
        return projectJpaRepository.saveAndFlush(project);
    }

    public Project update(int id, Project project) {
        get(id);
        return projectJpaRepository.saveAndFlush(project);
    }

    public Project get(int id) {
        Project project = projectJpaRepository.findOne(id);
        if (project == null) {
            throw new NotFoundException(id);
        }
        List<Project> projects = getAll();
        System.out.println(projects.contains(project));
        return project;
    }

    public void delete(int id) {
        Project project = get(id);
        projectJpaRepository.delete(project);
    }

    public List<Project> getAll() {
        return Helper.getCurrentUser().getProjects();
    }
}
