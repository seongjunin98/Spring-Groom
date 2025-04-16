package com.seongjun.mission08;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    /* 목표. @PostConstruct와 @PreDestroy 애너테이션을 사용하여 빈의 라이프사이클을 제어하고 실행 결과 스크린샷을 제출*/
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Bean bean = context.getBean(Bean.class);
        bean.doSomething();

        context.close();
    }
}
