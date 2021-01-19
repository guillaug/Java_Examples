package com.tudresden.graphqlexamples.graphqltutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class GraphqltutorialApplication {

	public static void main(String[] args) {
		System.out.println("Hello Spring Application");
		//SpringApplication.run(GraphqltutorialApplication.class, args);
		SpringApplication app = new SpringApplication(GraphqltutorialApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8083"));
		app.run(args);
	}

}
