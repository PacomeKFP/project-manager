package com.poo.projet.models;

import java.util.UUID;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "projets")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_p;

    private String name;

    @ManyToOne
    private User user;

    public UUID getId() {
        return this.id_p;
    }

    public void setId_p(UUID id) {
        this.id_p = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Project() {
    }

    public Project(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
