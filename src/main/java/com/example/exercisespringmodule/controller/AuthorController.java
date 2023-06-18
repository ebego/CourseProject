package com.example.exercisespringmodule.controller;


import com.example.exercisespringmodule.entity.Author;
import com.example.exercisespringmodule.exceptionhandler.FileNukUGjetException;
import com.example.exercisespringmodule.service.AuthorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AuthorController {
    private AuthorService authorService;
    public AuthorController(AuthorService authorService){
        this.authorService=authorService;
    }

    @GetMapping("/author")
    public List<Author> getAuthors(){
        return authorService.getAuthor();
    }
    @GetMapping("/author/{name}")
    public Author getAuthorByName(@PathVariable("name") String name) throws FileNukUGjetException {
        return authorService.getAuthorByName(name);
    }
    @PostMapping("/author")
    public void addAuthor(@Validated @RequestBody Author author)  {
        authorService.addAuthor(author);
    }

    @DeleteMapping("/author")
    public void deleteAuthor(@Validated @RequestBody Author author)  {
        authorService.deleteAuthor(author);
    }

}
