package com.example.exercisespringmodule.controller;

import com.example.exercisespringmodule.model.ErrorModel;
import com.example.exercisespringmodule.exceptionhandler.FileNukUGjetException;
import com.example.exercisespringmodule.entity.School;
import com.example.exercisespringmodule.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ProjectController {
    private SchoolService schoolService;


    public ProjectController(SchoolService schoolService){
        this.schoolService=schoolService;
    }

//    @GetMapping("/school")
//    public School getSchool(){
//        return new School(5, "Ali Demi", 400);
//    }

    @GetMapping("/school/{id}")
    public School getSchoolById(@PathVariable("id") int id) throws FileNukUGjetException {
        return schoolService.getSchoolById(id);
    }

    @GetMapping("/schools")
    public List<School> getSchools(){
        return schoolService.getSchools();
    }

    @GetMapping("/schoolmax")
    public School getSchoolWithMaxStudents(){
        return schoolService.getSchoolWithMaxStudents();
    }


//    @ExceptionHandler({ FileNukUGjetException.class})
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorModel handleFileNotFoundExceptions(FileNukUGjetException e){
//        return new ErrorModel(500,e.getMessage(),
//               "Choose one of the following id : " +
//                       schoolService.getSchools().stream().map(s-> s.getId()).collect(Collectors.toList()).toString()
//                , new String[0]);
//        return "Test Error";
    }



