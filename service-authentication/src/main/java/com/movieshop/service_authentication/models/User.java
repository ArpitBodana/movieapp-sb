package com.movieshop.service_authentication.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "all-users")
public class User {
    public String getUsername() {
        return username;
    }

    public User() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
