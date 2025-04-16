package com.seongjun.mission09;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    /* 목표. application.properties 또는 application.yml을 활용하여 설정 값을 주입합니다. 실행 결과를 통해 주입된 값이 올바르게 동작하는 지 확인하고 실행 결과 스크린샷을 제출. */

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Config config = context.getBean(Config.class);

        System.out.println("앱 이름: " + config.getAppName());
        System.out.println("앱 버전: " + config.getAppVersion());
        System.out.println(config.getGreetingMessage("성준"));

        context.close() ;
    }
}
