package com.movieshop.commentservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movieComments")
public class Comment {
    @Id
    @JsonProperty
    private String id;

    @JsonProperty
    private String movieId;

    @JsonProperty
    private String comment;

    @JsonProperty
    private String userName;

    public Comment(String movieId, String comment, String userName) {
        this.id=null;
        this.movieId = movieId;
        this.comment = comment;
        this.userName = userName;
    }
}
