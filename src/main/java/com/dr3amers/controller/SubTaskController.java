package com.dr3amers.controller;

import com.dr3amers.model.SubTask;
import com.dr3amers.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/projects/{projectId}/tasks/{taskId}/subtasks")
public class SubTaskController {

    private SubTaskService subTaskService;

    @Autowired
    public SubTaskController(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<SubTask> getAll() {
        return subTaskService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public SubTask get(@PathVariable("id") int id) {
        return subTaskService.get(id);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("taskId") int taskId,
                         @PathVariable("id") int id) {
        subTaskService.delete(taskId, id);
        return "SubTask with ID:" + id+ " was successfully deleted";
    }

}
