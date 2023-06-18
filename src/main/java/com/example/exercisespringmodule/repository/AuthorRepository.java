package com.example.exercisespringmodule.repository;

import com.example.exercisespringmodule.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findByAuthorName(String authorName);

    List<Author> findAll();

}
