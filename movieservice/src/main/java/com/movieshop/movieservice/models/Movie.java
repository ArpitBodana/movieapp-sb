package com.movieshop.movieservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movies")
public class Movie {
    @Id
    @JsonProperty
    private String id;

    @JsonProperty
    private String movieName;
    @JsonProperty
    private String movieDescription;
    @JsonProperty
    private String posterURl;
    @JsonProperty
    private Integer releaseYear;

    @Transient
    private List<Comment> comments;

    public Movie(String movieName, String movieDescription,String posterURl,Integer releaseYear) {
        this.id = null;  // Explicitly setting 'id' to null
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.posterURl=posterURl;
        this.releaseYear=releaseYear;
    }
}
// @Field(write = Field.Write.ALWAYS)
