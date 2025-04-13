package com.seongjun.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

        @Pointcut("execution(* com.seongjun.section01.aop.*Service.*(..))")
        public void logPointcuy() {}

        @Before("LoggingAspect.logPointcuy()")
        public void logBefore(JoinPoint joinPoint){

            System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());

            System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());
        }
    }

