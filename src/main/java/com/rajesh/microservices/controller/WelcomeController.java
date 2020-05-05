package com.rajesh.microservices.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.microservices.config.BasicConfig;
import com.rajesh.microservices.service.WelcomeService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class WelcomeController {
	
	@Autowired
	private WelcomeService service;
	
	@Autowired
	private BasicConfig config;
	
	@GetMapping("/welcome")
	@ResponseBody
	public String showWelcomeMessage() {
		return service.getWelcomeMessage();
	}
	
	@GetMapping("/messages")
	@ResponseBody
	public Map getMessages() {
		Map modelMap =  new HashMap();
		modelMap.put("Number", config.getNumber());
		modelMap.put("Message", config.getMessage());
		modelMap.put("Checked", config.isChecked());
		
		return modelMap;
	}
	
	@GetMapping("/restservices/helloworld")
	public HelloWorldBean returnBean() {
		return new HelloWorldBean("Hello World - Changed");
	}
	
	@GetMapping("/login/getlogininfo/{username}/{password}")
	public void validateAuth(@PathVariable String username,
			@PathVariable String password) {
		System.out.println("Username is "+username+" Password "+password);
		
	}
}
