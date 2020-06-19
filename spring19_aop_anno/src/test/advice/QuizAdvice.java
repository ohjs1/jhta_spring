package test.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class QuizAdvice {
	@Pointcut("execution(* test.quiz..*(..))")
	public void pointCutTarget() {
		
	}
	
	@Around("pointCutTarget()")
	public Object valueOfReturn(ProceedingJoinPoint joinPoint) throws Throwable {
		String name = joinPoint.getSignature().getName();
		System.out.println(name + " << ����� �޼ҵ� �̸�");
		Object returnValue = joinPoint.proceed();
		System.out.println("�޼ҵ� ������..." + returnValue);
		return returnValue;
	}
}
