package com.rajesh.microservices.angular.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rajesh.microservices.angular.model.Todo;
import com.rajesh.microservices.angular.service.TodoHardCodedService;


// Angular controller file
@CrossOrigin(origins="http://localhost:1841")
@RestController
public class TodoResources {
	
	@Autowired
	private TodoHardCodedService service;
	
	@GetMapping("/todo/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return service.findAll();
	}
	
	@GetMapping("/todo/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/todo/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		Todo todo = service.deleteById(id);
		
		if(todo != null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/todo/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(
			@PathVariable String username, 
			@PathVariable long id,
			@RequestBody Todo todo) {
		Todo todoUpdate = service.save(todo);
		
		if(todo != null) {
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<Todo>(todoUpdate, HttpStatus.OK);
	}
	
	@PostMapping("/todo/{username}/todos")
	public ResponseEntity<Void> createTodo(
			@PathVariable String username, 
			@RequestBody Todo todo) {
		Todo createdTodo = service.save(todo);
		
		if(createdTodo != null) {
			return ResponseEntity.noContent().build();
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
