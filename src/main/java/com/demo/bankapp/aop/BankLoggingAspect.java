package com.demo.bankapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BankLoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Pointcut("execution(* com.demo.bankapp.controllers.*.*(..))")
    private void forControllersPackage() {}

    @Pointcut("execution(* com.demo.bankapp.services.*.*(..))")
    private void forServicesPackage() {}

    @Pointcut("execution(* com.demo.bankapp.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllersPackage() || forServicesPackage() || forDAOPackage()")
    private void forApplication() {}

    @Before("forApplication()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("Info: in @Before Advice: Calling the Method: " + methodName);
    }

    @AfterReturning(value = "forApplication()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("Info: in @AfterReturning Advice: Calling the Method: " + methodName);
        logger.info("Info: Data Returned by Method: " + result);
    }
}
