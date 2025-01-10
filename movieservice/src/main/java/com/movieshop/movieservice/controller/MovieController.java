package com.movieshop.movieservice.controller;

import com.movieshop.movieservice.models.Movie;
import com.movieshop.movieservice.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService mvServ;

    @GetMapping("/getall")
    public ResponseEntity<List<Movie>> getMovies(){
        List<Movie> movies = mvServ.getAllMovies();
        System.out.println("Movies fetched: " + movies.size());  // Logging to check if data is being fetched
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie mv){
        return ResponseEntity.ok(mvServ.addMovie(mv));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Movie>> deleteMovie(@PathVariable("id") String id){
        return ResponseEntity.ok(mvServ.deleteMovie(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieDetails(@PathVariable String id){
        return ResponseEntity.ok(mvServ.getMovieById(id));
    }

}
