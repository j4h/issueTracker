package com.dr3amers.controller;

import com.dr3amers.model.Project;
import com.dr3amers.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id) {
        projectService.delete(id);
        return "Project with ID:" + id+ " was successfully deleted";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Project create(@RequestBody Project project) {
        return projectService.create(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Project update(@PathVariable("id") int id, @RequestBody Project project) {
        return projectService.update(id, project);
    }
}