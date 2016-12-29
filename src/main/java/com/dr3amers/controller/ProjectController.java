package com.dr3amers.controller;

import com.dr3amers.model.Project;
import com.dr3amers.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/{id}")
    public Project getProject(@PathVariable("id") int id){
        return projectService.get(id);
    }

    @GetMapping
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Project> getAll(){
        return projectService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") int id) {
        projectService.delete(id);
        return "Project with ID:" + id+ " was successfully deleted";
    }

    @PostMapping
    public Project create(@RequestBody @Valid Project project) {
        return projectService.create(project);
    }

    @PutMapping(value = "/{id}")
    public Project update(@PathVariable("id") int id, @RequestBody Project project) {
        return projectService.update(id, project);
    }

    //todo modelUpdateValidation this
    /*@GetMapping(value = "/modelUpdateValidation", produces="application/json")
    public String modelUpdateValidation() {
        JsonObject result = Json.createObjectBuilder()
                .add("name", "Dade")
                .add("age", 23)
                .add("married", false)
                .build();
        return result.toString();
    }*/
}