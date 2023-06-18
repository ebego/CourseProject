package com.example.exercisespringmodule.repository;

import com.example.exercisespringmodule.entity.Author;
import com.example.exercisespringmodule.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movies, Long> {

    Movies findByMovieTitle(String movieTitle);

    List<Movies> findAll();

//    List<Movies> findByMovieAuthor(String authorName);
}
