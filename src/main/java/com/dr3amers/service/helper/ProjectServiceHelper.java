package com.dr3amers.service.helper;

import com.dr3amers.exception.NotFoundException;
import com.dr3amers.model.Project;
import com.dr3amers.model.Task;
import com.dr3amers.repository.ProjectJpaRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

//here we hide some implementations from service to make it lighter
public class ProjectServiceHelper {

    public Timestamp setCurrentTimestamp() {
        java.util.Date date = new Date(System.currentTimeMillis());
        return new Timestamp(date.getTime());
    }

}
