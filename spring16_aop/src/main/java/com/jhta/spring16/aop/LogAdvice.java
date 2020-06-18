package com.jhta.spring16.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//공통기능 - 메소드 실행 전후에 동작
public class LogAdvice {
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//메소드 실행전에 해야할 기능 구현///////////////////////
		Object[] args = joinPoint.getArgs(); // 메소드로 전달된 파라미터
		for(Object arg : args) {
			System.out.println("매개변수:" + arg);
		}
		
		
		/////////////////////////////////////////
		Object returnValue = joinPoint.proceed(); // 핵심기능 메소드 호출
		/////// 메소드 실행후에 행할 기능 구현 //////////////////
		System.out.println("메소드 동작 완료!");
		System.out.println("메소드에서 리턴된 값: " + returnValue);
		
		
		////////////////////////////////////////
		return returnValue;
	}
}
