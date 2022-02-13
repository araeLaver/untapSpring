package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice
{

	@Before( "execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore()
	{
		log.info("========================");
		log.info("========================");
	}

	@Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2)
	{
		log.info("@@@@@@@@@@@@@@@@@@@@@@");
		log.info("str1: " + str1);
		log.info("str2: " + str2);
		log.info("@@@@@@@@@@@@@@@@@@@@@@");
	}

	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing="exception")
	// 지정된 대상이 예외를 발생한 후에서 동작하면서 문제를 찾을 수 있도록 한다.
	public void logException(Exception exception)
	{
		log.info("Exception....!!!!");
		log.info("exception: "+ exception);
	}


	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	// @Before 등과 달리 @Around가 적용되는 메서드의 경우에는 리턴 타입이 void가 아닌 타입으로 설정하고,
	// 메서드의 실행 결과 역시 직접 반환하는 형태로 작성해야만 한다.
	public Object logTime( ProceedingJoinPoint pjp)
	{
		long start = System.currentTimeMillis();

		log.info("Target: " + pjp.getTarget());
		log.info("Param: " + Arrays.toString(pjp.getArgs()));

		//invoke method
		Object result = null;

		try
		{
			result = pjp.proceed();
		}
		catch (Throwable e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}

		long end = System.currentTimeMillis();

		log.info(end);
		log.info("TIME: "  + (end - start));
		log.info(start);

		return result;
	}



}
