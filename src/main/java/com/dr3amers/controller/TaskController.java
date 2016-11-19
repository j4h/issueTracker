package com.dr3amers.controller;

import com.dr3amers.model.Task;
import com.dr3amers.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/projects/{projectId}/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Set<Task> getAll(@PathVariable ("projectId") int id){ return taskService.getAll(id); }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Task create(@PathVariable("projectId") int projectId, @RequestBody Task task) {
        return taskService.create(projectId, task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Task get(@PathVariable("projectId")int projectId, @PathVariable("id")int id) {
        return taskService.get(projectId, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Task update(@PathVariable("projectId") int projectId, @PathVariable("id") int id, @RequestBody Task task) {
        return taskService.update(projectId, id, task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("projectId") int projectId, @PathVariable("id") int id) {
        taskService.delete(projectId, id);
        return "Task with ID:" + id+ " was successfully deleted";
    }
}