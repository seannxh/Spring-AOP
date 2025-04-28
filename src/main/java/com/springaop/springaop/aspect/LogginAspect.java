package com.springaop.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
@Configuration
@Aspect
public class LogginAspect {
    //Weaving a framework that implements AOP AspectJ or Spring AOP
    //Run Time when the pointcut is condition and a specific execution instance is called JoinPoint
    // is the current place of package that my logic aka Advice is being applied to
    //Before aspect - Method is called - execution(int com.springaop.springaop.business.BusinessService.calculateMax())
    private Logger logger = LoggerFactory.getLogger(getClass());
    //When?
    //execution(*PACKAGE.*.*)
    @Before("execution(* com.springaop.springaop.business.*.*(..))")
    public void businessMethods(JoinPoint joinPoint) {
        logger.info("Before aspect - Method is called - {}", joinPoint);
        // empty — just a name for the pointcut
        logger.info("Before Aspect - {} is called with - {}", joinPoint, joinPoint.getArgs());
    }


}
