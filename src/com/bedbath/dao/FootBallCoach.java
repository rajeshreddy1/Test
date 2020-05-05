package com.bedbath.dao;

import com.bedbath.demo.Coach;
import com.bedbath.service.FortuneService;

public class FootBallCoach implements Coach{

	private FortuneService fortuneService;
	
	public FootBallCoach() {
		
	}
	
	@Override
	public String getDailyWorkouts() {
		// TODO Auto-generated method stub
		return "Practice";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

}
