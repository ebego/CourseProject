package com.example.exercisespringmodule.service;

import com.example.exercisespringmodule.entity.Author;
import com.example.exercisespringmodule.entity.Movies;
import com.example.exercisespringmodule.enums.Category;
import com.example.exercisespringmodule.exceptionhandler.FileNukUGjetException;
import com.example.exercisespringmodule.repository.MovieRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    MovieRepository movieRepository = mock(MovieRepository.class);

    MovieService movieService = new MovieService(movieRepository);



    @Test
    public void getMovieByTitle() throws FileNukUGjetException {

        Movies movie = new Movies();
        movie.setMovieTitle("Avengers");

        when(movieRepository.findByMovieTitle("Avengers")).thenReturn(movie);

        Movies foundMovie = movieService.getMovieByName("Avengers");

        Assert.assertEquals("Avengers", foundMovie.getMovieTitle());
    }

    @Test
    public void getNullMovieByTitle() throws FileNukUGjetException {


        when(movieRepository.findByMovieTitle("Avengers")).thenReturn(null);

        Movies foundMovie = movieService.getMovieByName("Avengers");

        Assert.assertNull(foundMovie);
    }

    @Test
    public void getNullAuthorFromMovies() throws FileNukUGjetException {

        when(movieRepository.findByMovieAuthor("Erdit Bego")).thenReturn(null);

        String getAuthor = movieService.getAuthorFromMovie("Erdit Bego");

        Assert.assertEquals("There is no movie at all!", getAuthor);

    }

    @Test
    public void getAuthorFromMovies() throws FileNukUGjetException {

        List<Movies> moviesList = new ArrayList<>();
        moviesList.add(new Movies(1L," ", Category.HORROR,null,0.0,LocalDate.now(),null,null));

        when(movieRepository.findByMovieAuthor("Erdit")).thenReturn(moviesList);

        String result = movieService.getAuthorFromMovie("Erdit");

        Assert.assertEquals("It is not allowed to show movies from this author", result);
    }

    @Test
    public void getAuthorFromMoviesWhenAuthorMatches() throws FileNukUGjetException {

        List<Movies> moviesList = new ArrayList<>();
        moviesList.add(new Movies(1L," ", Category.DRAMA,new Author(1,"Erdit","Bego",29,"Shqiptar"),0.0,LocalDate.now(),null,null));

        when(movieRepository.findByMovieAuthor("Erdit")).thenReturn(moviesList);

        String result1 = movieService.getAuthorFromMovie("Erdit");

        Assert.assertEquals("Erdit", result1);
    }


}
