package com.dr3amers.controller;

import com.dr3amers.model.Task;
import com.dr3amers.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/projects/{projectId}/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAll(@PathVariable ("projectId") int id){ return taskService.getAll(id); }

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

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("projectId") int projectId, @PathVariable("id") int id) {
        taskService.delete(projectId, id);
        return "Task with ID:" + id+ " was successfully deleted";
    }
}