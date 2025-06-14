package com.efm.efm_backend.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.ManyToMany;

import java.util.Set;
import java.util.HashSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @ManyToMany(mappedBy = "employees")
    private Set<Project> projects = new HashSet<>();
}

// Add other getters/setters similarly if needed

