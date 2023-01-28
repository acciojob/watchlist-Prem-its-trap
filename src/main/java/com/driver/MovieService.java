package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director){
        return movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair(String moviename, String directorname){
        return movieRepository.addMovieDirectorPair(moviename,directorname);
    }

    public Movie getMovieByName(String moviename){
        return movieRepository.getMoviesByName(moviename);
    }

    public Director getDirectorByName(String dirname){
        return movieRepository.getDirectorByName(dirname);
    }

    public List<String> getMoviesByDirectorName(String name){
        return movieRepository.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String name){
        return movieRepository.deleteDirectorByName(name);
    }

    public String deleteAllDirectors(){
        return  movieRepository.deleteAllDirectors();
    }
}