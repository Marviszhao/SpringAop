package com.spring.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAspect {
	@Pointcut("execution(* com.spring.service.I_UserService.checkUser(..))")
	public void loginAspect(){}
	
	@Before("loginAspect()")
	public void beforeLogin(JoinPoint joinPoint){
//		1 第一步执行
		System.out.println("beforeLogin action---");
	}
	
	@After("loginAspect()")
	public void afterLogin(JoinPoint joinPoint){
//		4 第四步执行
		System.out.println("afterLogin action---");
	}
	
	@Around("loginAspect()")
	public Object aroundLogin(ProceedingJoinPoint joinPoint)
			throws java.lang.Throwable {
//		2 第二步执行
		System.out.println("执行登录方法之前，模拟开始事务 ..."); 
		Object rvt = joinPoint.proceed(); 
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
//		5 第五步执行
		System.out.println("参数:"+method.getTypeParameters()+";切入方法："+method.getName()+";返回值："+method.getReturnType());
		System.out.println("执行目标方法之后，模拟结束事务 ..."); 
		return rvt; 
	}
	
	 @AfterReturning(returning="rvt", pointcut="loginAspect()")
	 public void afterReturning(Object rvt){ 
//		3  第三步执行
		 System.out.println("获取登陆结果返回值 :" + rvt); 
		 System.out.println("添加登录成功日志功能 ..."); 
	 } 
	 
//	 如果执行切点方法被抛出异常，则1，2，4步执行后执行@AfterThrowing增强处理。 @AfterReturning将不再执行
	 @AfterThrowing(pointcut="loginAspect()",throwing="ex")
	 public void afterThrowingSayHello(Exception ex){
		 System.out.println("After Throwing : "+ex.getMessage());
	 }
	    
}
