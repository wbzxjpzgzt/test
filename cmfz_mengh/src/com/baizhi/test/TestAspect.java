package com.baizhi.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class TestAspect {
	/*
	 * 参数pjp 是环绕通知中的固定参数，不允许有其他参数
	 * 
	 * */
	@Around("execution(com.baizhi.service.*.*(..))")
	public Object log(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("进入环绕通知");
		
		
		System.out.println("当前目标类"+pjp.getTarget());
		System.out.println("参数数组"+pjp.getArgs());
		System.out.println("当前方法的签名"+pjp.getSignature());
		System.out.println("当前目标的代理类"+pjp.getThis().getClass());
		//之前
		Object proceed = pjp.proceed();
		//之后
		//放行请求
		return proceed;
	}
}
