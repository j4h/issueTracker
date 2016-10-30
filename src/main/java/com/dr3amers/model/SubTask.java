package com.dr3amers.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class SubTask {

    @Id
    private int id;
    @Column(unique = true)
    @NotEmpty
    private String name;
    private String description;
    @Column(name = "creation_date")
    private Timestamp creation_date;
    @Column(name = "modification_date")
    private Timestamp modification_date;

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
}
