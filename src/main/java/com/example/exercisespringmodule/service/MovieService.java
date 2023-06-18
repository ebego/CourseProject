package com.example.exercisespringmodule.service;

import com.example.exercisespringmodule.entity.*;
import com.example.exercisespringmodule.enums.Category;
import com.example.exercisespringmodule.exceptionhandler.FileNukUGjetException;
import com.example.exercisespringmodule.repository.MovieRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Service
public class MovieService {


    private MovieRepository movieRepository;
    private static List<Movies> moviesList = new ArrayList<>();
    private static List<Author> authors = new ArrayList<>();

//    @Autowired
//    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }



//    static {
//        List<Season> season = new ArrayList<>();
//        List<Episode> episode = new ArrayList<>();
//        List<Actor> actor = new ArrayList<>();
//        actor.add(new Actor(0,"Ersela"));
//        actor.add(new Actor(0,"Ergi"));
//        episode.add(new Episode(0,"Nuk ka",0));
//        season.add(new Season(0,0,episode));
//
//        authors.add(new Author(0,"Erdit", "Bego",29, "Albanian"));
//        moviesList.add(new Movies(0,"Avengers", Category.FANTASY, authors.get(0),5.5, LocalDate.of(2015,05,26), actor,new ArrayList<>()));
//        List<Actor> actor1 = new ArrayList<>();
//        actor1.add(new Actor(0,"Mario"));
//        actor1.add(new Actor(0,"Kristian"));
//        List<Season> season1 = new ArrayList<>();
//        List<Episode> episode1 = new ArrayList<>();
//        episode1.add(new Episode(1,"Amazing waters",1));
//        episode1.add(new Episode(1,"Deep waters",2));
//        episode1.add(new Episode(1,"The Sea",3));
//        episode1.add(new Episode(1,"Ending",4));
//        season1.add(new Season(1,0,episode1));
//        authors.add(new Author(1,"Anxhela", "Murati",27, "Albanian"));
//        moviesList.add(new Movies(1,"Deti", Category.ROMANCE, authors.get(1),9.5, LocalDate.of(2020,10,18), actor1, season1 ));
//        List<Actor> actor2 = new ArrayList<>();
//        actor2.add(new Actor(0,"Majlinda"));
//        actor2.add(new Actor(0,"Eno"));
//        List<Season> season2 = new ArrayList<>();
//        List<Episode> episode2 = new ArrayList<>();
//        episode2.add(new Episode(2,"The Moon",1));
//        episode2.add(new Episode(2,"The Sun",2));
//        season2.add(new Season(2,0,episode2));
//        authors.add(new Author(2,"Steven", "Spielberg",50, "American"));
//        moviesList.add(new Movies(2,"Interstellar", Category.THRILLER, authors.get(2),8.7, LocalDate.of(2019,9,05), actor2, season2 ));
//
//    }

    public void addMovie(Movies movie){
//        moviesList.add(movie);
            movieRepository.save(movie);
    }

    public Movies getMovieByName(String name) throws FileNukUGjetException {
//        if(moviesList.stream().filter(s->s.getMovieTitle().equals(name)).noneMatch(p-> true) == true){
//            throw new FileNukUGjetException("Not found exception");
//        }
//        return moviesList.stream().filter(s->s.getMovieTitle().equals(name)).findFirst().get();
       return movieRepository.findByMovieTitle(name);
    }
    public List<Movies> getMovieByAuthor(Enum category) throws FileNukUGjetException {
        if(moviesList.stream().filter(s->s.getMovieCategory().equals(category)).noneMatch(p-> true) == true){
            throw new FileNukUGjetException("Not found exception");
        }
        return moviesList.stream().filter(s->s.getMovieCategory().equals(category)).collect(Collectors.toList());

    }

//    public CustomModel getSeasonWithMostEpisodes(){
//        int nrSezonit = moviesList.stream()
//                .flatMap(m->m.getMovieSeason().stream())
//                .map(s-> s.getEpisodes().size())
//                .max(Comparator.naturalOrder())
//                .get();
//
//        Movies movie = moviesList.stream()
//                .filter(m-> m.getMovieSeason()
//                        .stream()
//                        .map(s-> s.getEpisodes().size() == nrSezonit)
//                        .findFirst()
//                        .orElse(false)
//                ).findFirst().get();
//
//        return new CustomModel(movie.getMovieTitle(), nrSezonit, movie.getAuthor().getAuthorName());
//
//    }
//
//    public List<String> getMoviesByAuthorWithRateBetterThan3AndMoreThan2Seasons(String authorName){
//       return moviesList.stream()
//                .filter(m-> m.getAuthor().getAuthorName().equals(authorName))
//                .filter(r->r.getMovieRate() > 3)
//                .filter(s->s.getMovieSeason().size() >= 1)
//                .sorted(Comparator.comparing(Movies::getMovieRate).reversed())
//                .flatMap(m->m.getMovieSeason().stream())
//                .flatMap(s->s.getEpisodes().stream())
//                .map(Episode::getEpisodeName)
//                .collect(Collectors.toList());
//
//    }
//
//    public List<Episode> getEpisodesByAuthor(String authorName){
//
//      return  moviesList.stream()
//                .filter(m-> m.getAuthor().getAuthorName().equals(authorName))
//                .flatMap(m-> m.getMovieSeason().stream())
//                .flatMap(s->s.getEpisodes().stream())
//                .collect(Collectors.toList());
//    }



//    public List<Movies> getMovies(){
////        return moviesList;
//
//        return movieRepository
//    }
    public List<Movies> getMovies(){
        List<Movies> result = new ArrayList();
        movieRepository.findAll().forEach(result::add);
        return result;
    }

    public String getAuthorFromMovie(String authorName){
        List<Movies> movie = movieRepository.findByMovieAuthor(authorName);

        if (!Objects.isNull(movie)) {
            if (movie.get(0).getMovieCategory().equals(Category.HORROR)) {
                return "It is not allowed to show movies from this author";
            } else {
                return movie.get(0).getAuthor().getAuthorName();
            }
        }
        else {
            return "There is no movie at all!";
        }
    }

}
