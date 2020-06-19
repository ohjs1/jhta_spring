package test.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
//�޼ҵ� �������� ���۵Ǵ� �����̽�
public class MyAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("ȣ��Ǵ� �޼ҵ�:" + method);
		System.out.print("���޵Ǵ� �Ķ���� -->");
		for(Object arg : args) {
			System.out.println(arg + ",");
		}
		System.out.println();
	}
	
}
