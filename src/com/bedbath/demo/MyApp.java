package com.bedbath.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		/*
		 * // TODO Auto-generated method stub Coach myCoach = new CoachImpl();
		 * System.out.println(myCoach.getDailyWorkouts());
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach myCoach = context.getBean("myCoach", Coach.class);
		context.close();
	}

}
