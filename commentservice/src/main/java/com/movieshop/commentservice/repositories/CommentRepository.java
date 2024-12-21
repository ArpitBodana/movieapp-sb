package com.movieshop.commentservice.repositories;

import com.movieshop.commentservice.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {

    List<Comment> findCommentByMovieId(String movieId);


    long deleteAllByMovieId(String MovieId);
}
