package com.dr3amers.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;

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
    //private User creator;
    //private User implementer;
    @Column(name = "creation_date")
    private Timestamp creation_date;
    @Column(name = "modification_date")
    private Timestamp modification_date;

    //private List<SubTask> subTaskList  = new ArrayList<>();

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
/*
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getImplementer() {
        return implementer;
    }

    public void setImplementer(User implementer) {
        this.implementer = implementer;
    }*/

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

}