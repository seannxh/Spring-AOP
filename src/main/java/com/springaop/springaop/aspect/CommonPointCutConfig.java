package com.springaop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

    @Pointcut("execution(* com.springaop.springaop.business.*.*(..))")
    public void businessPackageConfig(){}

    @Pointcut("execution(* com.springaop.springaop.data.*.*(..))")
    public void DataPackageConfig(){}

    @Pointcut("bean(*Service*)")
    public void allPackageConfig(){}

    @Pointcut("@annotation(com.springaop.springaop.data.TrackTime)")
    public void trackTimeAnnotation(){}


}
