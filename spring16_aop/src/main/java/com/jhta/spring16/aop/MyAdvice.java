package com.jhta.spring16.aop;

public class MyAdvice {
	//���� ���ɻ��� - �����̽�
	public void test() {
		System.out.println("�޼ҵ���� �����ؾ��� ���� ��� ����");
	}
	
	public void afterMethod() {
		System.out.println("�޼ҵ尡 ������Ŀ� ������ �۾� ����...");
	}
}
