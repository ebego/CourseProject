package com.example.exercisespringmodule.controller;

import com.example.exercisespringmodule.dto.UserDTO;
import com.example.exercisespringmodule.entity.User;
import com.example.exercisespringmodule.model.AuthenticationRequest;
import com.example.exercisespringmodule.repository.UserRepository;
import com.example.exercisespringmodule.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/auth")
    public String login(@RequestBody AuthenticationRequest authenticationRequest){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = userRepository.findByUsername(authenticationRequest.getUsername());

        if(user != null && passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword()))
            return jwtUtil.generateToken(user.getUsername());

        throw new AuthenticationServiceException("KREDENCIALET GABIM!");
    }

    @PostMapping("/auth")
    public void addUser(@RequestBody UserDTO user){

        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

        user.setPassword(crypt.encode(user.getPassword()));

        User userEntity = new User();

        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());

        userRepository.save(userEntity);
    }

    @PutMapping("/auth")
    public List<User> login(){
        return userRepository.findAll();
    }

}
