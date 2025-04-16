package com.seongjun.mission06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    /* 목표. Spring 프레임워크에서 인터페이스를 활용하여 의존성을 주입합니다. 인터페이스를 정의하고, 구현 클래스를 생성합니다. 인터페이스 기반 의존성 주입 코드를 작성하고, 실행 결과를 확인합니다. 결과물로 인터페이스 기반 의존성 주입 코드와 실행 결과 스크린샷을 제출*/
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
            MessagePrinter printer = context.getBean(MessagePrinter.class);
            printer.printMessage();
            }

    }
}
