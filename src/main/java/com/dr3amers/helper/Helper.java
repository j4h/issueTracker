package com.dr3amers.helper;

import com.dr3amers.model.Task;
import com.dr3amers.repository.TaskJpaRepository;

import java.sql.Date;
import java.sql.Timestamp;

public class Helper {

    public static Timestamp setCurrentTimestamp() {
        java.util.Date date = new Date(System.currentTimeMillis());
        return new Timestamp(date.getTime());
    }

    public static Timestamp setOldCreationDate(Task task, TaskJpaRepository taskJpaRepository) {
        return taskJpaRepository.findOne(task.getId()).getCreation_date();
    }
}
