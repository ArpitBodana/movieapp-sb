package com.movieshop.commentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.movieshop")
public class CommentserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentserviceApplication.class, args);
	}

}
