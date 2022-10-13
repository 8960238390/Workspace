package com.seleniumexpress.trans.spring_transactional_01.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("within(com..service.*) || within(com..repo.*)")
	public void logMethodpointcut() {
		
	}
	
	@Around("logMethodpointcut()")
	public Object LogMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String name = proceedingJoinPoint.getSignature().getName();
		
		System.out.println("method execution starting : "+name);
		
		Object returnedValue = proceedingJoinPoint.proceed();
		
		System.out.println(returnedValue);
		
		System.out.println("method execution ending : "+name);
		
		return returnedValue;
	}
}