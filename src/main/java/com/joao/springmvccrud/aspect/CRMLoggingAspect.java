package com.joao.springmvccrud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Aspect
@Component
public class CRMLoggingAspect {

    private final Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

    @Pointcut("execution(* com.joao.springmvccrud.controllers.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.joao.springmvccrud.services.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.joao.springmvccrud.dao.*.*(..))")
    private void forDAOPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    private void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("=====>> in @Before calling method: " + methodName);

        String methodArgs = Arrays.stream(joinPoint.getArgs()).map(Object::toString).collect(Collectors.joining(","));
        logger.info("=====>> in @Before method's args: " + methodArgs);
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    private void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("=====>> in @AfterReturning calling method: " + methodName);
        logger.info("=====>> in @AfterReturning method result: " + result);
    }

}
