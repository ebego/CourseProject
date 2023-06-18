package com.example.exercisespringmodule.controller;

import com.example.exercisespringmodule.entity.Actor;
import com.example.exercisespringmodule.exceptionhandler.FileNukUGjetException;
import com.example.exercisespringmodule.service.ActorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ActorController {
    private ActorService actorService;
    public ActorController(ActorService actorService){
        this.actorService=actorService;
    }

    @GetMapping("/actor")
    public List<Actor> getActor(){
        return actorService.getAuthor();
    }
    @GetMapping("/actor/{name}")
    public Actor getActorByName(@PathVariable("name") String name) throws FileNukUGjetException {
        return actorService.getAuthorByName(name);
    }
    @PostMapping("/actor")
    public void addActor(@Validated @RequestBody Actor actor)  {
        actorService.addActor(actor);
    }

    @DeleteMapping("/actor")
    public void deleteActor(@Validated @RequestBody Actor actor)  {
        actorService.deleteActor(actor);
    }
}
