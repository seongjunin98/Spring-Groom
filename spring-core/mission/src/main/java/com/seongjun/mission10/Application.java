package com.seongjun.mission10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
/* 목표. 동일한 타입의 여러 빈이 있을 때 @Qualifier를 사용하여 특정 빈을 선택적으로 주입하는 방법을 구현하고 실행 결과 스크린샷을 제출.*/
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        PrinterService service = context.getBean(PrinterService.class);
        service.doPrint();

        context.close();
    }
}
