package com.example.exercisespringmodule.model;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;
}