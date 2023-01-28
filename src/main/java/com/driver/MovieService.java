package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public String addMovieDirectorPair(String mname, String dname){
        return movieRepository.addMovieDirectorPair(mname,dname);
    }
    public Movie getMovie(String name){
        return movieRepository.getMovie(name);
    }
    public Director getDirector(String name){
        return movieRepository.getDirector(name);
    }
    public List<String> findAllMovies(){
        return  movieRepository.findAllMovies();
    }

    public List<String> getMoviesByDirectorName(String name){
        return movieRepository.getMoviesByDirectorName(name);
    }

    public String deleteByname(String name){
        return movieRepository.deleteDirectorByName(name);
    }
    public String deleteAllDirector(){
        return movieRepository.deleteAllDirectorsAndMovie();
    }
}
