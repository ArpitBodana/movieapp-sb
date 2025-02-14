package com.movieshop.movieservice.services;

import com.movieshop.movieservice.config.JwtFilter;
import com.movieshop.movieservice.feign.CommentInterface;
import com.movieshop.movieservice.models.Comment;
import com.movieshop.movieservice.models.Movie;
import com.movieshop.movieservice.repositories.MovieRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository mvRepo;
    @Autowired
    private CommentInterface commentDao;

    public List<Movie> getAllMovies(){
        return mvRepo.findAll();
    }

    public Movie addMovie(Movie movie){
        return mvRepo.save(movie);
    }

    public Optional<Movie> deleteMovie(String Id){
        Optional<Movie> del = mvRepo.findById(Id);
        mvRepo.deleteById(Id);
        return del;
    }

    public Optional<Movie> getMovieById(String Id){
        Optional<Movie> mv =mvRepo.findById(Id);
        try {
            List<Comment> cmnts = commentDao.getAllCommentsOfMovie(Id).getBody();
            if(mv.isPresent() && !cmnts.isEmpty()){
                mv.get().setComments(cmnts);
            }
        }catch (Exception e){
            System.out.println("comment service is down!!!");
        }
        return mv;
    }


}
