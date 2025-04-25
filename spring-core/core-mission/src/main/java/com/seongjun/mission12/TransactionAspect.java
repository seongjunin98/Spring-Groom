package com.seongjun.mission12;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    @Around("@annotation(com.seongjun.mission12.Transactional)")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println(" 트랜잭션 시작");
            Object result = joinPoint.proceed();
            System.out.println(" 트랜잭션 커밋");
            return result;
        } catch (Exception e) {
            System.out.println(" 트랜잭션 롤백 - 예외: " + e.getMessage());
            throw e;
        }
    }
}
