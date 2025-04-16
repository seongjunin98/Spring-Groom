package com.seongjun.mission05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    /* 목표 : Spring 프레임워크의 AOP(Aspect-Oriented Programming) 기능을 활용하여 애스펙트를 구현합니다. 애스펙트를 정의하고, 타깃 메서드에 애스펙트를 적용합니다. AOP가 올바르게 동작하는지 확인하기 위해 실행 결과를 확인합니다. 결과물로 AOP를 적용한 코드와 실행 결과 스크린샷을 제출
    * */
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
            Calculator calculator = context.getBean(Calculator.class);

            int sum = calculator.add(10, 5);
            System.out.println("더하기 결과 : " + sum);

            int difference = calculator.subtract(10, 5);
            System.out.println("빼기 결과 : " + difference);
        }
    }
}
