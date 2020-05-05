package com.bedbath.demo;

public class BaseballCoach implements Coach{
	
	public String getDailyWorkouts() {
		return "practice 30 minutes batting";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "lucky";
	}
}
