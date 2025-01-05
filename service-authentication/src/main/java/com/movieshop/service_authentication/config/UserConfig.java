package com.movieshop.service_authentication.config;



import com.movieshop.service_authentication.models.User;
import com.movieshop.service_authentication.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    @Bean
    public CommandLineRunner userCommandLineRunner(UserRepository repo){
        return args -> {
            if(repo.findAll().isEmpty()){
                User user1 = new User("Arpit","1234");
                User user2 = new User("Chiku","1234");
                user1.setPassword(encoder.encode(user1.getPassword()));
                user2.setPassword(encoder.encode(user2.getPassword()));
                repo.saveAll(List.of(user1,user2));
            }
        };
    }
}
