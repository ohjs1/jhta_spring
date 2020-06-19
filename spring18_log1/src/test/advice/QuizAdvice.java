package test.advice;
/*
 * 메소드 실행후에 메소드 리턴값을 출력하는 어드바이스를 만들고 적용되도록 해보세요 (AfterRetuninAdvice상속)
 */

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class QuizAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("호출되는 메소드" + method);
		System.out.println("메소드 리턴값 : " + returnValue);
	}
	
}
