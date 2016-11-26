package com.dr3amers.helper;

import com.dr3amers.exception.InvalidStatusUpdateException;
import com.dr3amers.exception.NotFoundException;
import com.dr3amers.model.*;
import com.dr3amers.model.enumerated.Status;
import com.dr3amers.repository.ProjectJpaRepository;
import com.dr3amers.repository.TaskJpaRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Set;

public class Helper {

    public static AuthenticatedUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (AuthenticatedUser) auth.getPrincipal();
    }

    public static Project getProjectById(ProjectJpaRepository projectJpaRepository, int id)
            throws RuntimeException {

        Project project = projectJpaRepository.findOne(id);
        if (project == null)
            throw new NotFoundException("Project with ID:"+id+" don't exists.");

        Project project1 = findProjectById(getCurrentUser().getProjects(),id);
        if (project1 != null && project1.getId() == project.getId())
            return project;

        throw new AccessDeniedException("You have no access to project with ID:"+id);
    }

    public static Task getTaskById(ProjectJpaRepository projectJpaRepository, TaskJpaRepository taskJpaRepository,
                                   int projectId, int taskId)
            throws RuntimeException {

        Project project = getProjectById(projectJpaRepository,projectId);
        Task task = taskJpaRepository.findOne(taskId);

        if (task == null)
            throw new NotFoundException("Task with ID:"+taskId+" don't exists.");

        Task task1 = findTaskById(project.getTasks(),taskId);
        if (task1 != null && task1.getId() == task.getId())
            return task;

        throw new AccessDeniedException("You have no access to task with ID:"+taskId);
    }

    //rule for changing status
    public static Task checkStatusUpdateValidity(ProjectJpaRepository projectJpaRepository, TaskJpaRepository taskJpaRepository,
                                                 int projectId, int taskId, Task task)
            throws RuntimeException {

        Task task1 = getTaskById(projectJpaRepository, taskJpaRepository, projectId, taskId);
        if (task.getStatus() == Status.DONE && task1.getStatus() == Status.TODO)
            throw new InvalidStatusUpdateException(task.getStatus(), task1.getStatus());

        return task;
    }

    public static SubTask getSubTaskByIdFromTask(ProjectJpaRepository projectJpaRepository, TaskJpaRepository taskJpaRepository,
                                                 int projectId, int taskId, int subTaskId)
        throws RuntimeException {

        Set<SubTask> subTasks = getTaskById(projectJpaRepository, taskJpaRepository, projectId, taskId).getSubTaskList();
        for (SubTask subtask:subTasks) {
            if (subtask.getId() == subTaskId)
                return subtask;
        }
        throw new NotFoundException(taskId);
    }

    private static Project findProjectById(List<Project> projects, int id) {

        for (Project project:projects) {
            if (project.getId() == id)
                return project;
        }
        return null;
    }

    private static Task findTaskById(Set<Task> tasks, int id) {

        for (Task task:tasks) {
            if (task.getId() == id)
                return task;
        }
        return null;
    }
}
