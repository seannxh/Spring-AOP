package com.springaop.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



//!!!!!!!!! Find out how long it took for the method to execute
@Configuration
@Aspect
public class PerformaceAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //ProceedingJoinPoint can get the method and execute it
    @Around("execution(* com.springaop.springaop.business.*.*(..))")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //Start a timer
        long StartTimelines = System.currentTimeMillis();
        //Execute the method
        Object returnValue = proceedingJoinPoint.proceed();
        //Stop the timer
        long StopTimeMillis = System.currentTimeMillis();

        long executionDuration = StopTimeMillis - StartTimelines;
        logger.info("Around Aspect - {} Method Executed In {}"
                ,proceedingJoinPoint,executionDuration
                );
        return returnValue;
    }
}
