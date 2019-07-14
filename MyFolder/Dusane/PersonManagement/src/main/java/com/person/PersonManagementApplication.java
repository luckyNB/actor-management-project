package com.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableAutoConfiguration
@SpringBootApplication
public class PersonManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonManagementApplication.class, args);
	}

}
