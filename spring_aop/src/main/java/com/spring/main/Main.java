package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.pointcut.Behavior;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext cxt = new GenericXmlApplicationContext("classpath:com/spring/context/application-context.xml");
		Behavior behavior = cxt.getBean("behavior", Behavior.class);
		
		behavior.밥먹기();
		behavior.공부하기();
		behavior.잠자기();
		behavior.운동();
		behavior.데이트();
		behavior.놀기();
		behavior.정신수양();
		
	}
	
}
