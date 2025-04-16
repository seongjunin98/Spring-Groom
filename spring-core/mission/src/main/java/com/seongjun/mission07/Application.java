package com.seongjun.mission07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    /* 목표. XML이 아닌 @Configuration과 @Bean을 사용하여 빈을 정의하고, 의존 관계를 설정합니다. 결과물로 JavaConfig 기반의 빈 설정 코드 및 실행 결과 스크린샷을 제출. */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);

        printer.printMessage();

        context.close();
    }
}
