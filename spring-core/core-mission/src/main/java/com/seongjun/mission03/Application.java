package com.seongjun.mission03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    /* 목표. Spring 프레임워크에서 발생할 수 있는 순환 의존성 문제를 해결합니다. 순환 의존성이 발생하는 상황을 재현하고, 이를 해결하기 위한 코드를 작성합니다. 순환 의존성 문제가 해결되었는지 확인하기 위해 실행 결과를 확인합니다. 결과물로 순환 의존성 문제를 해결한 코드와 실행 결과 스크린샷을 제출.
    * */
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){
            A a = context.getBean(A.class);
            System.out.println(a.callB());
        } catch (Exception e){
            System.out.println("오류 발생 : " + e.getMessage());
        }
    }
}
