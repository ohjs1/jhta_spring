package com.jhta.spring16.aop;

public class MyAdvice {
	//공통 관심사항 - 어드바이스
	public void test() {
		System.out.println("메소드들이 실행해야할 공통 기능 구현");
	}
	
	public void afterMethod() {
		System.out.println("메소드가 종료된후에 수행할 작업 구현...");
	}
}
