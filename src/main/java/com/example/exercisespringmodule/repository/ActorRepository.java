package com.example.exercisespringmodule.repository;

import com.example.exercisespringmodule.entity.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    Actor findByCastName(String castName);

    Iterable<Actor> findAll();

}
