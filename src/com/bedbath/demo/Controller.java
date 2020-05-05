package com.bedbath.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bedbath.service.CoachImpl;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach myCoach = context.getBean("myFootBallCoach", Coach.class);
		System.out.println(myCoach.toString());
		System.out.println(myCoach.getDailyWorkouts());
		System.out.println(myCoach.getFortune());
		context.close();
	}

}
