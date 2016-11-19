package com.dr3amers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such object")
public class NotFoundException extends RuntimeException {


    public NotFoundException(int projectId, int taskId) {
        super("Task with ID: " +taskId+ " doesn't exist in project with ID: "+ projectId+"");
    }
    public NotFoundException(int id) {
        super("ID: " +id + " not found.");
    }
    public NotFoundException(String value) {
        super("Object with value: " +value + " not found.");
    }

    public String toString(){
        return this.getMessage() +"\n" + getClass();
    }
}
