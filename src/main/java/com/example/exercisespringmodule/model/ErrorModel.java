package com.example.exercisespringmodule.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorModel {
    private int status;
    private String message;
    private String description;
    private List<String> data;

}