package test.advice;
/*
 * �޼ҵ� �����Ŀ� �޼ҵ� ���ϰ��� ����ϴ� �����̽��� ����� ����ǵ��� �غ����� (AfterRetuninAdvice���)
 */

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class QuizAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("ȣ��Ǵ� �޼ҵ�" + method);
		System.out.println("�޼ҵ� ���ϰ� : " + returnValue);
	}
	
}
