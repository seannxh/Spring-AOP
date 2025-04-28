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

    private Logger logger = LoggerFactory.getLogger(getClass());
    //When?
    //execution(*PACKAGE.*.*)
    @Before("execution(* com.springaop.springaop.business.*.*(..))")
    public void businessMethods(JoinPoint joinPoint) {
        logger.info("Before aspect - Method is called - {}", joinPoint);
        // empty — just a name for the pointcut
    }


}
