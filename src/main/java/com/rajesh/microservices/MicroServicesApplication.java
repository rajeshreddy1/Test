package com.rajesh.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rajesh")
public class MicroServicesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServicesApplication.class, args);
	}
}
