package com.movieshop.commentservice.controllers;

import com.movieshop.commentservice.models.Comment;
import com.movieshop.commentservice.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Comment>> getAllCommentsOfMovie(@PathVariable String id){
        return ResponseEntity.ok(commentService.getAllCommentsOfMovie(id));
    }

    @DeleteMapping("/{id}")
    public Optional<Comment> deleteById(@PathVariable String id){
        Optional<Comment> res = commentService.getCommentById(id);
        commentService.deleteById(id);
        return res;
    }
    @DeleteMapping("/deletebymovie/{id}")
    public String deleteByMovieId(@PathVariable String id){
        Long res = commentService.deleteByMovieId(id);
        return "Total Comments delete count is "+res;
    }

    @PostMapping("/")
    public Comment addOrUpdateComment(@RequestBody Comment comment){
        return commentService.addAndUpdateComment(comment);
    }
}
