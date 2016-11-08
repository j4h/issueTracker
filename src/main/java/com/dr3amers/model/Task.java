package com.dr3amers.model;

import com.dr3amers.model.enumerated.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    private User creator;
    @ManyToOne
    private User assignee;
    @Column(name = "creation_date")
    private Timestamp creation_date;
    @Column(name = "modification_date")
    private Timestamp modification_date;

    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany
    @JoinColumn(name = "task_id")
    private List<SubTask> subTaskList  = new ArrayList<>();

    @JsonIgnore
    @Column(name = "project_id")
    private int projectId;

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

    public User getCreator() { return creator; }

    public void setCreator(User creator) { this.creator = creator; }

    public User getAssignee() { return assignee; }

    public void setAssignee(User assignee) { this.assignee = assignee; }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public Timestamp getModification_date() {
        return modification_date;
    }

    public void setModification_date(Timestamp modification_date) {
        this.modification_date = modification_date;
    }

    public void setProjectId(int projectId) { this.projectId = projectId; }

    public int getProjectId() { return projectId; }

    public List<SubTask> getSubTaskList() { return subTaskList; }

    public void setSubTaskList(List<SubTask> subTaskList) { this.subTaskList = subTaskList; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

}