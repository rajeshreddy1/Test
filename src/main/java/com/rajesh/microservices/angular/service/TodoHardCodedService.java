package com.rajesh.microservices.angular.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rajesh.microservices.angular.model.Todo;

@Service
public class TodoHardCodedService {

	private static List<Todo> todos = new ArrayList<Todo>(); 
	private static int counter = 0;
	
	static {
		todos.add(new Todo(++counter,"Rajesh","Learn Springboot", new Date(), true));
		todos.add(new Todo(++counter,"Rajesh","Learn Angular", new Date(), false));
		todos.add(new Todo(++counter,"Rajesh","Learn React", new Date(), false));
	}
	
	public List<Todo> findAll() {
		return todos;
	}
	
	public Todo save(Todo todo) {
		
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++counter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteById( long id) {
		Todo todo = findById(id);
		
		if(todo == null) return null;
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		
		for(Todo todo: todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
