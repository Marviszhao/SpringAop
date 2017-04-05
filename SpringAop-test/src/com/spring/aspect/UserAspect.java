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
//		1 ��һ��ִ��
		System.out.println("beforeLogin action---");
	}
	
	@After("loginAspect()")
	public void afterLogin(JoinPoint joinPoint){
//		4 ���Ĳ�ִ��
		System.out.println("afterLogin action---");
	}
	
	@Around("loginAspect()")
	public Object aroundLogin(ProceedingJoinPoint joinPoint)
			throws java.lang.Throwable {
//		2 �ڶ���ִ��
		System.out.println("ִ�е�¼����֮ǰ��ģ�⿪ʼ���� ..."); 
		Object rvt = joinPoint.proceed(); 
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
//		5 ���岽ִ��
		System.out.println("����:"+method.getTypeParameters()+";���뷽����"+method.getName()+";����ֵ��"+method.getReturnType());
		System.out.println("ִ��Ŀ�귽��֮��ģ��������� ..."); 
		return rvt; 
	}
	
	 @AfterReturning(returning="rvt", pointcut="loginAspect()")
	 public void afterReturning(Object rvt){ 
//		3  ������ִ��
		 System.out.println("��ȡ��½�������ֵ :" + rvt); 
		 System.out.println("��ӵ�¼�ɹ���־���� ..."); 
	 } 
	 
//	 ���ִ���е㷽�����׳��쳣����1��2��4��ִ�к�ִ��@AfterThrowing��ǿ���� @AfterReturning������ִ��
	 @AfterThrowing(pointcut="loginAspect()",throwing="ex")
	 public void afterThrowingSayHello(Exception ex){
		 System.out.println("After Throwing : "+ex.getMessage());
	 }
	    
}
