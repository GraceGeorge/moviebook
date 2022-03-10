package com.movie.theatre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class TheatreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreApplication.class, args);
	}

}
