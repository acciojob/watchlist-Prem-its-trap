package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    HashMap<String, Movie> db = new HashMap<String, Movie>();
    HashMap<String, Director> ddb = new HashMap<>();
    HashMap<String,List<String>> directorMovieMapping = new HashMap<>();
    public String addMovie(Movie movie){
        String name = movie.getName();
        db.put(name,movie);
        return "Movie added successfully";
    }

    public String addDirector(Director director){
        String name = director.getName();
        ddb.put(name,director);
        return "Director added successfully";
    }

    public void addMoveiDirectorPair(String mname, String dname){
        if(db.containsKey(mname) && ddb.containsKey(dname)){
            db.put(mname, db.get(mname));
            ddb.put(dname,ddb.get(dname));
            List<String> currentMovies = new ArrayList<>();
            if(directorMovieMapping.containsKey(dname)) currentMovies = directorMovieMapping.get(dname);
            currentMovies.add(mname);
            directorMovieMapping.put(dname,currentMovies);
        }
    }

    public Movie getMovie(String name){
        return db.get(name);
    }
    public Director getDirector(String name){
        return  ddb.get(name);
    }

    public List<String> getMoviesByDirectorName(String dirname){
        List<String> ls = new ArrayList<>();
        if(directorMovieMapping.containsKey(dirname)) ls = directorMovieMapping.get(dirname);
        return ls;
    }

    //7 get all movies
    public ArrayList<String> findAllMovies(){
        ArrayList<String> ls = new ArrayList<>();
        for(Map.Entry<String,Movie> e:db.entrySet()){
            ls.add(e.getKey());
        }
        return ls;
    }



    // 9 delete all the directors and all movies
    public void deleteAllDirectorsAndMovie(){
        HashSet<String> hs = new HashSet<>();

        for(String director: directorMovieMapping.keySet()){
            for (String movie : directorMovieMapping.get(director)){
                hs.add(movie);
            }
        }
        for (String movie : hs){
            if(db.containsKey(movie)){
                db.remove(movie);
            }
        }

    }

}
