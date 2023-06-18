package com.example.exercisespringmodule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomModel {
    private String movie;
    private int season;
    private String author;
}
