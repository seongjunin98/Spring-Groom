package com.seongjun.mission05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.seongjun.mission05.Calculator.*(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("[Before Aspect] 메서드 실행 전 록ㅇ");
        System.out.println("Target 메서드 : " + joinPoint.getSignature().getName());
        System.out.println("인수 : " + Arrays.toString(joinPoint.getArgs()));
    }
}
