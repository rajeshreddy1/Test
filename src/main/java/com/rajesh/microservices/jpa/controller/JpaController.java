package com.rajesh.microservices.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rajesh.microservices.jpa.model.User;
import com.rajesh.microservices.jpa.repo.UserRepository;

//Jpa controller
@Controller
public class JpaController {
	
	@Autowired
	private UserRepository repository;

	@GetMapping("/jpausers")
	@ResponseBody
	public List<User> getAllUsers(){
		
		return repository.findAll();
	}
	
	@GetMapping("/jpauser/{id}")
	@ResponseBody
	public Optional<User> getUser(@PathVariable int id){
		
		return repository.findById(id);
	}
	
	@PostMapping("/adduser")
	public User saveUser(@RequestBody User user) {
		
		return repository.save(user);
	}

	@GetMapping("/jpa/{role}")
	@ResponseBody
	public List<User> getByRole(@PathVariable String role) {
		System.out.println("test");
		return repository.findByRole(role);
	}
}
