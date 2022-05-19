package com.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceBehavior {

	public void chikachika() {
		System.out.println("==치카푸카푸카푸카푸카푸카푸==");
	}
	
	//joinpoint : around
	public void chikachikaAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("한번닦았눈뎅");
		joinPoint.proceed();
		System.out.println("또 닦아요!!!!!!!");
	}
}
