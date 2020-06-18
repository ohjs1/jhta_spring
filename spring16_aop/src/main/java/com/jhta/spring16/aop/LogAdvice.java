package com.jhta.spring16.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//������ - �޼ҵ� ���� ���Ŀ� ����
public class LogAdvice {
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//�޼ҵ� �������� �ؾ��� ��� ����///////////////////////
		Object[] args = joinPoint.getArgs(); // �޼ҵ�� ���޵� �Ķ����
		for(Object arg : args) {
			System.out.println("�Ű�����:" + arg);
		}
		
		
		/////////////////////////////////////////
		Object returnValue = joinPoint.proceed(); // �ٽɱ�� �޼ҵ� ȣ��
		/////// �޼ҵ� �����Ŀ� ���� ��� ���� //////////////////
		System.out.println("�޼ҵ� ���� �Ϸ�!");
		System.out.println("�޼ҵ忡�� ���ϵ� ��: " + returnValue);
		
		
		////////////////////////////////////////
		return returnValue;
	}
}
