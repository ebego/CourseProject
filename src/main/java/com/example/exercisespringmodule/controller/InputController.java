package com.example.exercisespringmodule.controller;

import com.example.exercisespringmodule.exceptionhandler.ExceptionKontrolloFjalen;
import com.example.exercisespringmodule.service.InputService;
import com.example.exercisespringmodule.model.ObjectStatusMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class InputController {

    private InputService inputService;

    public InputController(InputService inputService) {
        this.inputService=inputService;
    }

    @GetMapping("/word/{msg}")
    @ResponseStatus(HttpStatus.OK)
    public ObjectStatusMapping getInput(@PathVariable String msg) throws ExceptionKontrolloFjalen {
        return new ObjectStatusMapping(200, inputService.checkVowels(msg)) ;
    }

    @ExceptionHandler({ ExceptionKontrolloFjalen.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ObjectStatusMapping handleFileNotFoundExceptions(ExceptionKontrolloFjalen e){
        return new ObjectStatusMapping(400,0);
//        return "Test Error";
    }


}
