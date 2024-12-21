package com.movieshop.movieservice.feign;

import com.movieshop.movieservice.models.Comment;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient("COMMENTSERVICE")
public interface CommentInterface {
    @GetMapping("api/comments/{id}")
    public ResponseEntity<List<Comment>> getAllCommentsOfMovie(@PathVariable String id);
}
