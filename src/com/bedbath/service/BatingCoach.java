package com.bedbath.service;

import com.bedbath.demo.Coach;

public class BatingCoach implements Coach{

	private FortuneService fortuneService;
	
	public BatingCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkouts() {
		// TODO Auto-generated method stub
		return "Practice 5 hrs everyday";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
