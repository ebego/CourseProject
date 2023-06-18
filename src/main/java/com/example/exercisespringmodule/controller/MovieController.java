package com.example.exercisespringmodule.controller;

import com.example.exercisespringmodule.entity.CustomModel;
import com.example.exercisespringmodule.entity.Episode;
import com.example.exercisespringmodule.entity.Movies;
import com.example.exercisespringmodule.enums.Category;
import com.example.exercisespringmodule.exceptionhandler.ExceptionMethodArgument;
import com.example.exercisespringmodule.exceptionhandler.FileNukUGjetException;
import com.example.exercisespringmodule.model.ErrorModel;
import com.example.exercisespringmodule.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class MovieController {

    private MovieService movieService;
    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }
    @GetMapping("/movie")
    public List<Movies> getMovies(){
        return movieService.getMovies();
    }
    @GetMapping("/movie/{name}")
        public Movies getMovieByName(@PathVariable("name") String name) throws FileNukUGjetException {
            return movieService.getMovieByName(name);
    }
    @GetMapping("/movie/category/{category}")
    public List<Movies> getMovieByAuthor(@PathVariable("category") String category) throws FileNukUGjetException {
        return movieService.getMovieByAuthor(Category.valueOf(category.toUpperCase()));
    }

    @PostMapping("/movie")
    public void addMovie(@Validated @RequestBody Movies movie)  {
        movieService.addMovie(movie);
    }

//    @GetMapping("/movie/episodes/{author}")
//    public List<Episode> getEpisodeByAuthor(@PathVariable String author){
//        return movieService.getEpisodesByAuthor(author);
//    }
//    @GetMapping("/movie/movies/{author}")
//    public List<String> getMoviesByAuthorWithRateBetterThan3AndMoreThan2Seasons(@PathVariable String author){
//        return movieService.getMoviesByAuthorWithRateBetterThan3AndMoreThan2Seasons(author);
//    }
//
//    @GetMapping("/movie/ushtrim")
//    public CustomModel getSeasonWithMostEpisodes(){
//        return movieService.getSeasonWithMostEpisodes();
//    }
//    Category.valueOf(category)

//    @ExceptionHandler({ FileNukUGjetException.class})
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorModel handleFileNotFoundExceptions(FileNukUGjetException e){
//        return new ErrorModel(500,e.getMessage(),
//                "Choose one of the following names : " +
//                        movieService.getMovies().stream().map(s-> s.getMovieTitle()).collect(Collectors.toList()).toString()
//                , new String[0]);
//    }

    @ExceptionHandler({org.springframework.validation.BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorModel badRequest(org.springframework.validation.BindException e){
        List<String> errorData = e.getFieldErrors().stream().map(
                ex->"Error on object "
                        + ex.getObjectName()
                        + " in the property "
                        + ex.getField()
                        + " value " + "\'"
                        + ex.getRejectedValue() + "\'"
                        + " " + ex.getDefaultMessage()
        ).collect(Collectors.toList());
        return new ErrorModel(400, "Validation Error!", "Check the fields in data!", errorData);
    }
}
