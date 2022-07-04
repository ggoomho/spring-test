package com.spring.sample.master.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogAspect {
    
    @Pointcut("execution(* com.spring.sample.master.service.*.*(..))")
    public void serviceExecution() {}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMapping() {}


    //@Before("execution(* com.spring.sample.master.service.*.*(..))")
    @Before(value = "getMapping()")
    public void beforeLog(JoinPoint jp) {
        String typeName = jp.getSignature().getDeclaringTypeName();
        String name = jp.getSignature().getName();
        log.info("[BEFORE] - " + typeName + " / " + name);
    }

    @After("execution(* com.spring.sample.master.service.*.*(..))")
    public void afterLog(JoinPoint jp) throws Throwable {
        String typeName = jp.getSignature().getDeclaringTypeName();
        String name = jp.getSignature().getName();
        log.info("[AFTER] - " + typeName + " / " + name);
    }

    @AfterReturning("execution(* com.spring.sample.master.service.*.*(..))")
    public void afterReturningLog(JoinPoint jp) {
        String typeName = jp.getSignature().getDeclaringTypeName();
        String name = jp.getSignature().getName();
        log.info("[AFTER-RETURNING] - " + typeName + " / " + name);
    }

    @AfterThrowing("execution(* com.spring.sample.master.service.*.*(..))")
    public void afterThrowingLog(JoinPoint jp) {
        String typeName = jp.getSignature().getDeclaringTypeName();
        String name = jp.getSignature().getName();
        log.info("[AFTER-THROWING] - " + typeName + " / " + name);
    }

    @Around("execution(* com.spring.sample.master.service.*.*(..))")
    public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();

        log.info("[SERVICE METHOD]");
        log.info(" - Class: " + pjp.getSignature().getDeclaringTypeName());
        log.info(" - Method: " + pjp.getSignature().getName());
        log.info(" - Time: " + (endTime - startTime) + "ms");

        return result;
    }


 
}
