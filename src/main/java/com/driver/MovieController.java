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
    @PostMapping("/movies/add-movie") // ADD MOVIE
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String res = movieService.addMovie(movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director") // ADD DIRECTOR
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String res = movieService.addDirector(director);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String mname, @RequestParam("director") String dname){

         String ans = movieService.addMovieDirectorPair(mname,dname);
         if(ans.equals("movie does not exist") || ans.equals("director does not exist")){
             return new ResponseEntity<>(ans, HttpStatus.BAD_REQUEST);
         }
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        Movie movie = movieService.getMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        Director director = movieService.getDirector(name);
        return new ResponseEntity<>(director, HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public  ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(name),HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name){
        String res = movieService.deleteByname(name);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String res = movieService.deleteAllDirector();
        return new ResponseEntity(res, HttpStatus.CREATED);
    }

}
