package com.rajesh.microservices.jpa.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rajesh.microservices.jpa.model.User;

@Component
public class UserCommanLineRunner implements CommandLineRunner{
	
	
	@Autowired
	private UserRepository repository;

	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new User("Ranga", "Admin"));
	//	repository.save(new User("Ranga", "Admin"));
		repository.save(new User("Ravi", "User"));
		repository.save(new User("Satish", "Admin"));
	//	repository.save(new User("Raghu", "User"));

		for (User user : repository.findAll()) {
			System.out.println(user.toString());
		}

		System.out.println("Admin users are.....");
		System.out.println("____________________");
		for (User user : repository.findAll()) {
			System.out.println(user.toString());
		}
		
	}

}
