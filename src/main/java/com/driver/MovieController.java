package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/movies/add-movie") // ADD MOVIE
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String res = movieService.addMovie(movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director") // ADD DIRECTOR
    public ResponseEntity addDirector(@RequestBody Director director){
        String res = movieService.addDirector(director);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("mname") String mname, @RequestParam("dname") String dname){
         movieService.addMovieDirectorPair(mname,dname);

        return new ResponseEntity<>("New movie director pair added",HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
        Movie movie = movieService.getMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        Director director = movieService.getDirector(name);
        return new ResponseEntity<>(director, HttpStatus.FOUND);
    }


    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> ls = movieService.findAllMovies();
        return new ResponseEntity<>(ls,HttpStatus.FOUND);
    }

}
