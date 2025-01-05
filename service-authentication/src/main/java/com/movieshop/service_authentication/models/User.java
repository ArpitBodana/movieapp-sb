package com.movieshop.service_authentication.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "all-users")
public class User {

    @Id
    @JsonProperty
    private String id;


    @JsonProperty
    private String username;

    @JsonProperty
    private String password;

    public User(String username,String password){
        this.id=null;
        this.username=username;
        this.password=password;
    }

}
