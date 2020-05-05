package com.rajesh.microservices.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	@Value("${welcome.message}")
	private String message;

	public String getWelcomeMessage() {
		return message;
	}
}
