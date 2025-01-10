package com.movieshop.commentservice.config;

import com.movieshop.commentservice.models.Comment;
import com.movieshop.commentservice.repositories.CommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class CommentConfig {

    @Bean
    public CommandLineRunner seedCommentData(CommentRepository repo){
        return args -> {

            if(repo.findAll().isEmpty()){

                System.out.println("Seeding Commet DB.....");
                Comment c1 = new Comment("67813532aa59d205871d7c32","Intellectually bankrupt, morally reprehensible and stylistically inept, Sandeep Reddy Vanga's Animal is about as irredeemable as they come.","Rohan Nahar");
                Comment c2 = new Comment("67813532aa59d205871d7c32","Bigger, longer, bloodier: Animal is all that and more.","Daniel Egan");
                Comment c3 = new Comment("67813532aa59d205871d7c33","Shahid Kapoor takes the movie and tries to run with it. But he has been a hero at the centre-stage for too long; his responses are too practiced, too familiar. He feels too old for this role.", "Shubhra Gupta");
                Comment c4 = new Comment("67813532aa59d205871d7c33","If this is the great idea of man-woman dynamics, if this is a \"hatke\" love story, well just tell me another one. End of rant!","Namrata Joshi");
                Comment c5 = new Comment("67813532aa59d205871d7c34","An Action Hero chooses victimhood over vicious satire. The humour is forced, the satire is toothless, and the meta-commentary pedestrian.","Rohan Naahar");
                Comment c6= new Comment("67813532aa59d205871d7c34","Khurrana’s skill at playing a man in a tight spot is most useful in a film that frequently paints itself into corners.","Nandini Ramnath");
                Comment c7= new Comment("67813532aa59d205871d7c35","War is a popcorn entertainer and you can't ask too many questions but if you're willing to suspend disbelief, the twists and turns exert a solid grip.","Anupama Chopra");
                Comment c8= new Comment("67813532aa59d205871d7c35","War settles into a series of long-drawn-out action set pieces and contrived plot sleights designed to give Hrithik and Tiger the room to go all out.","Saibal Chatterjee");

                repo.saveAll(Arrays.asList(c1,c2,c4,c3,c5,c6,c7,c8));

                System.out.println("Seeding done for Comment DB......");
            }
        };
    }
}
