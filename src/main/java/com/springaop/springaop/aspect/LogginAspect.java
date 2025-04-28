package com.springaop.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
    @Before("com.springaop.springaop.aspect.CommonPointCutConfig.allPackageConfig()")
    public void businessMethods(JoinPoint joinPoint) {
        logger.info("Before aspect - Method is called - {}", joinPoint);
        // empty — just a name for the pointcut
        logger.info("Before Aspect - {} is called with - {} args", joinPoint, joinPoint.getArgs());
    }
    //@After Do something after a method is executed whether it went successfully or exception
    //@AfterReturning - Do something ONLY after it is executed successfully
    //@AfterThrowing - Do Something ONlY after it there is exeption.
    @After("com.springaop.springaop.aspect.CommonPointCutConfig.businessPackageConfig() || com.springaop.springaop.aspect.CommonPointCutConfig.DataPackageConfig()")
    public void afterBusinessAndDataMethods(JoinPoint joinPoint) {
        logger.info("After aspect - Method is called - {}", joinPoint);
        logger.info("After Aspect - {} has been executed w/ - {} args", joinPoint, joinPoint.getArgs());
    }

    @AfterThrowing(pointcut = "com.springaop.springaop.aspect.CommonPointCutConfig.DataPackageConfig()", throwing=  "exception")//Both Acception and Exception
    public void afterThrowingBusinessMethods(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing aspect - Method is called - {}", joinPoint);
        // empty — just a name for the pointcut
        logger.info("AfterThrowing Aspect - {} has been executed w/ - {} args", joinPoint, exception);
    }
    @AfterReturning(pointcut = "com.springaop.springaop.aspect.CommonPointCutConfig.DataPackageConfig()", returning = "resultValue")//Both Acception and Exception
    public void afterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("AfterReturning aspect - Method is called - {}", joinPoint);
        // empty — just a name for the pointcut
        logger.info("AfterReturning Aspect - {} has been executed w value of {}", joinPoint, resultValue);
    }

}
