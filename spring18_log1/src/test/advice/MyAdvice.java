package test.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
//메소드 실행전에 동작되는 어드바이스
public class MyAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("호출되는 메소드:" + method);
		System.out.print("전달되는 파라미터 -->");
		for(Object arg : args) {
			System.out.println(arg + ",");
		}
		System.out.println();
	}
	
}
