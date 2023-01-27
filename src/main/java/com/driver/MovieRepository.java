package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    HashMap<String, Movie> db = new HashMap<String, Movie>();
    HashMap<String, Director> ddb = new HashMap<>();
    HashMap<String,String> directorMovieMapping = new HashMap<>();
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

    public String addMovieDirectorPair(String mname, String dname){
        if(!db.containsKey(mname)){
            return "movie does not exist";
        }
        if(!db.containsKey(dname)){
            return "director does not exist";
        }
        directorMovieMapping.put(mname,dname);
        return "Movie and director pair added successfully";
    }

    public Movie getMovie(String name){
        return db.get(name);
    }
    public Director getDirector(String name){
        return  ddb.get(name);
    }

    public List<String> getMoviesByDirectorName(String dirname){
        if(!ddb.containsKey(dirname)) {
            return null;
        }
        List<String> ls = new ArrayList<>();
        for(String a : directorMovieMapping.keySet()){
            if(directorMovieMapping.get(a).equals(dirname)){
                ls.add(a);
            }
        }
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


    public String deleteDirectorByName(String name){
        HashSet<String> hs = new HashSet<>();
        ddb.remove(name);
        for(String dir: directorMovieMapping.keySet()){
            if(directorMovieMapping.get(dir).equals(name)){
                hs.add(dir);
            }
        }
        for(String  a: hs){
            db.remove(a);
            directorMovieMapping.remove(a);
        }
        return "Delete Successfully";
    }


    // 9 delete all the directors and all movies
    public String deleteAllDirectorsAndMovie(){
        HashSet<String> hs = new HashSet<>();

       for(String dir:directorMovieMapping.keySet()){
           hs.add(dir);
       }
       for(String a : hs){
           db.remove(a);
           directorMovieMapping.remove(a);
       }
       ddb.clear();
       return "Deleted all directors and related movie";

    }

}
