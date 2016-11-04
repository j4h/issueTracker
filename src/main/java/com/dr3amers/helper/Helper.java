package com.dr3amers.helper;

import com.dr3amers.exception.NotFoundException;
import com.dr3amers.model.Project;
import com.dr3amers.model.SubTask;
import com.dr3amers.model.Task;
import com.dr3amers.repository.ProjectJpaRepository;
import com.dr3amers.repository.TaskJpaRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Helper {

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

    public static Project getProjectById(ProjectJpaRepository projectJpaRepository, int id)
        throws RuntimeException {
        Project project = projectJpaRepository.findOne(id);
        if (project == null) {
            throw new NotFoundException(id);
        }
        return project;
    }

    public static Timestamp setCurrentTimestamp() {
        java.util.Date date = new Date(System.currentTimeMillis());
        return new Timestamp(date.getTime());
    }

    public static Timestamp setOldCreationDate(Task task, TaskJpaRepository taskJpaRepository) {
        return taskJpaRepository.findOne(task.getId()).getCreation_date();
    }


}
