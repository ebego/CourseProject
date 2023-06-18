package com.example.exercisespringmodule.service;

import com.example.exercisespringmodule.entity.Author;
import com.example.exercisespringmodule.exceptionhandler.FileNukUGjetException;
import com.example.exercisespringmodule.repository.AuthorRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void addAuthor(Author author){
        authorRepository.save(author);
    }
    public void deleteAuthor(Author author){
        authorRepository.delete(author);
    }
    public Author getAuthorByName(String name) throws FileNukUGjetException {
        return authorRepository.findByAuthorName(name);
    }

    public List<Author> getAuthor(){
        List<Author> result = new ArrayList();
        authorRepository.findAll().forEach(result::add);
        return result;
    }



}
