package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;
    //add a movie
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }
    //add a director
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        return new ResponseEntity<>(movieService.addDirector(director),HttpStatus.CREATED);
    }
    //add movie director pair
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String moviename,@RequestParam("director") String directorname){
        String ans = movieService.addMovieDirectorPair(moviename,directorname);
        if(ans.equals("movie does not exist") || ans.equals("director does not exist")){
            return new ResponseEntity<>(ans,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    //get movie details using name
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String moviename){
        return new ResponseEntity<>(movieService.getMovieByName(moviename),HttpStatus.FOUND);
    }
    //get director details using name
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String dirname){
        return new ResponseEntity<>(movieService.getDirectorByName(dirname),HttpStatus.CREATED);
    }
    //get list of movies using director name...confused in implementaion
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(name),HttpStatus.FOUND);
    }

    //get list of all movies added
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.FOUND);
    }
    //delete director
    @DeleteMapping
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name){
        return new ResponseEntity<>(movieService.deleteDirectorByName(name),HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return new ResponseEntity<>(movieService.deleteAllDirectors(),HttpStatus.CREATED);
    }
    }