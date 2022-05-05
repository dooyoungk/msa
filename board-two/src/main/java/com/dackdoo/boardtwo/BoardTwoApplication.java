package com.dackdoo.boardtwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BoardTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardTwoApplication.class, args);
	}

}
