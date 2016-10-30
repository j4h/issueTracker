package com.dr3amers.controller;

import com.dr3amers.model.Project;
import com.dr3amers.model.Task;
import com.dr3amers.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController (ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Project getProject(@PathVariable("id") int id){
        return projectService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAll(){
        return projectService.getAll();
    }

    @RequestMapping(value = "/{idp}/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task getTask(@PathVariable("idp") int idp, @PathVariable("id") int id) {
        Project project = projectService.get(idp);
        return project.getTasks().get(id - 1);
    }
}