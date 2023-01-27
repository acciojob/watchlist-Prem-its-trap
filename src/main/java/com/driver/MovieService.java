package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }
    public  String addDirector(Director director){
        return movieRepository.addDirector(director);
    }

    public Movie getMovie(String name){
        return movieRepository.getMovie(name);
    }

    public void addMovieDirectorPair(String mname, String dname){
         movieRepository.addMoveiDirectorPair(mname,dname);
    }
    public Director getDirector(String name){
        return movieRepository.getDirector(name);
    }
    public ArrayList<String> findAllMovies(){
        return  movieRepository.findAllMovies();
    }

    public void deleteAllDirector(){
        movieRepository.deleteAllDirectorsAndMovie();
    }
}
