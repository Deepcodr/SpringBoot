package com.deepcodr.example.secretmanagerimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecretmanagerimplApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretmanagerimplApplication.class, args);
		System.out.println("Started Secret Manager Application");
	}

}
