package com.yummee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YummeeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(YummeeBackendApplication.class, args);
		System.out.println("Yummee Project Running!");
	}
}