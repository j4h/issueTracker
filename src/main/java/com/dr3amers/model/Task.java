package com.dr3amers.model;

import com.dr3amers.model.enumerated.Status;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty
    @Column(unique = true)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "creation_date")
    @CreatedDate
    @Generated(value = GenerationTime.ALWAYS)
    private java.util.Date creation_date;
    @Column(name = "modification_date")
    @LastModifiedDate
    private java.util.Date modification_date;
    @Column(name = "project_id")
    private int projectId;
    @Column(name = "creator_id")
    private int creatorId;
    @Column(name = "assignee_id")
    private int assigneeId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    private List<SubTask> subTaskList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreatorId() { return creatorId; }

    public void setCreatorId(int creatorId) { this.creatorId = creatorId; }

    public int getAssigneeId() { return assigneeId; }

    public void setAssigneeId(int assigneeId) { this.assigneeId = assigneeId; }

    public java.util.Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(java.util.Date creation_date) {
        this.creation_date = creation_date;
    }

    public java.util.Date getModification_date() {
        return modification_date;
    }

    public void setModification_date(java.util.Date modification_date) {
        this.modification_date = modification_date;
    }

    public void setProjectId(int projectId) { this.projectId = projectId; }

    public int getProjectId() { return projectId; }

    public List<SubTask> getSubTaskList() { return subTaskList; }

    public void setSubTaskList(List<SubTask> subTaskList) { this.subTaskList = subTaskList; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

}