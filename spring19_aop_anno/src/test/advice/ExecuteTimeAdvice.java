package test.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
//Aspect : 공통기능(Advice) + 포인트컷 + 시점(before, after, around,...)
@Aspect
public class ExecuteTimeAdvice {
	@Pointcut("execution(* test.quiz..*(..))")
	public void timeTarget() {
		
	}
	@Around("timeTarget()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object returnValue = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		String method = joinPoint.getSignature().getName();
		double t = (endTime - startTime)/1000.0;
		System.out.println(method + "수행시간 : " + t + "초");
		
		return returnValue;
	}
}
