package com.seongjun.mission01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 목표. Spring 프레임워크에서 구성 파일(예: application.xml)을 사용하여 빈을 정의합니다. 빈 간의 의존 관계를 설정하고, 해당 관계를 코드에서 구현합니다. 빈 간 관계가 올바르게 구현되었는지 확인하기 위해 실행 결과를 확인합니다. 결과물로 빈 간 관계가 구현된 코드와 실행 결과 스크린샷을 제출.
    * 1. Chef class -> 요리함
    * 2. Restaurant class -> 내부의 Chef 사용
    * 3. xml에서 두 클래스 Bean으로 등록하고 연결
* */

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mission01/application.xml");

        Restaurant restaurant = context.getBean("restaurant", Restaurant.class);
        restaurant.serve();
    }
}
