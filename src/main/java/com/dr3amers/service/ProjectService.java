package com.dr3amers.service;

import com.dr3amers.helper.Helper;
import com.dr3amers.model.Project;
import com.dr3amers.repository.ProjectJpaRepository;
import com.dr3amers.validator.CrudAccessValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectJpaRepository projectJpaRepository;

    public Project create(Project project) {
        project.setCreatorId(Helper.getCurrentUser().getId());
        return projectJpaRepository.saveAndFlush(project);
    }

    public Project update(int id, Project project) {
        get(id);
        return projectJpaRepository.saveAndFlush(project);
    }

    public Project get(int id) {
        return Helper.getProjectById(projectJpaRepository,id);
    }

    //actually, we aren't delete any data, just hide it
    public void delete(int id) {
        //validation process
        Project project = get(id);
        CrudAccessValidator.modelUpdateValidation(project, project.getCreatorId());
        //hiding process
        setAllBoundEntitiesDeleted(project);
        projectJpaRepository.saveAndFlush(project);
    }

    public List<Project> getAll() {
        return Helper.getCurrentUser().getProjects();
    }

    private void setAllBoundEntitiesDeleted(Project project) {
        project.setDeleted(true);
        project.getTasks().forEach(task -> task.setDeleted(true));
        project.getTasks().forEach(task -> task.getSubTaskList().forEach(subTask -> subTask.setDeleted(true)));
    }
}
