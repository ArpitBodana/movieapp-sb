package com.movieshop.commentservice.services;

import com.movieshop.commentservice.models.Comment;
import com.movieshop.commentservice.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllCommentsOfMovie(String Id){
        return commentRepository.findCommentByMovieId(Id);
    }
    public Comment addAndUpdateComment(Comment comment){
        return commentRepository.save(comment);
    }

    public Optional<Comment> deleteById(String Id){
        Optional<Comment> res = commentRepository.findById(Id);
        commentRepository.deleteById(Id);
        return res;
    }

    public Optional<Comment> getCommentById(String Id){
        return commentRepository.findById(Id);
    }
    public long deleteByMovieId(String Id){
        return commentRepository.deleteAllByMovieId(Id);
    }
}
