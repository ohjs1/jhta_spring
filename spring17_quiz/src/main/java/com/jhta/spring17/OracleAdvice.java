package com.jhta.spring17;

import org.aspectj.lang.ProceedingJoinPoint;

public class OracleAdvice {
	public void getTimes(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		System.out.println("시간 재는중..");
		Object returnValue = joinPoint.proceed();
		System.out.println("===========완료============");
	}
}
