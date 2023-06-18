package com.example.exercisespringmodule.service;

import com.example.exercisespringmodule.entity.Actor;
import com.example.exercisespringmodule.entity.Author;
import com.example.exercisespringmodule.exceptionhandler.FileNukUGjetException;
import com.example.exercisespringmodule.repository.ActorRepository;
import com.example.exercisespringmodule.repository.AuthorRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public void addActor(Actor actor){
        actorRepository.save(actor);
    }
    public void deleteActor(Actor actor){
        actorRepository.delete(actor);
    }
    public Actor getAuthorByName(String name) throws FileNukUGjetException {
        return actorRepository.findByCastName(name);
    }
    public List<Actor> getAuthor(){
        List<Actor> result = new ArrayList();
        actorRepository.findAll().forEach(result::add);
        return result;
    }
}
