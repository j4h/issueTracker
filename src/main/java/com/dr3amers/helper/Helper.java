package com.dr3amers.helper;

import com.dr3amers.exception.InvalidStatusUpdateException;
import com.dr3amers.exception.NotFoundException;
import com.dr3amers.model.*;
import com.dr3amers.model.enumerated.Status;
import com.dr3amers.repository.ProjectJpaRepository;
import com.dr3amers.repository.TaskJpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Helper {

    public static AuthenticatedUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (AuthenticatedUser) auth.getPrincipal();
    }


    public static Task checkStatusUpdateValidity(ProjectJpaRepository projectJpaRepository, int projectId,
                                                 int taskId, Task task) throws RuntimeException {

        Task task1 = getTaskByIdFromProject(projectJpaRepository, projectId, taskId);
        if (task.getStatus() == Status.DONE && task1.getStatus() == Status.TODO) {
            throw new InvalidStatusUpdateException(task.getStatus(), task1.getStatus());
        }
        return task;
    }

    public static Project getProjectById(ProjectJpaRepository projectJpaRepository, int id)
            throws RuntimeException {
        Project project = projectJpaRepository.findOne(id);
        if (project == null) {
            throw new NotFoundException(id);
        }
        return project;
    }

    public static Task getTaskByIdFromProject(ProjectJpaRepository projectJpaRepository, int projectId, int taskId)
        throws RuntimeException {
        List<Task> tasks = projectJpaRepository.findOne(projectId).getTasks();
        for (Task task:tasks) {
            if (task.getId() == taskId){
                return task;
            }
        }
        throw new NotFoundException(taskId);
    }

    public static SubTask getSubTaskByIdFromTask(ProjectJpaRepository projectJpaRepository, int projectId, int taskId, int subTaskId)
        throws RuntimeException {
        List<SubTask> subTasks = getTaskByIdFromProject(projectJpaRepository,projectId,taskId).getSubTaskList();
        for (SubTask subtask:subTasks) {
            if (subtask.getId() == subTaskId){
                return subtask;
            }
        }
        throw new NotFoundException(taskId);
    }
}
