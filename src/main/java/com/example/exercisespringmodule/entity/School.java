package com.example.exercisespringmodule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table
public class School {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int numriIStudenteve;

}
