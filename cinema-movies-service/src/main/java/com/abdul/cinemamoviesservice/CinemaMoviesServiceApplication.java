package com.abdul.cinemamoviesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CinemaMoviesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaMoviesServiceApplication.class, args);
	}

}
