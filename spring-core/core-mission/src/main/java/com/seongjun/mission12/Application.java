package com.seongjun.mission12;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    /* 목표. AOP를 사용하여 트랜잭션을 관리하는 애스펙트를 구현합니다. @Transactional 애너테이션과 AOP를 결합하여 메서드 실행 전후로 트랜잭션을 제어하고, 예외 발생 시 롤백을 처리합니다. 결과물로 AOP를 활용한 코드와 실행 결과 스크린샷을 제출.*/
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        MyService service = context.getBean(MyService.class);

        System.out.println("========== 정상 처리 ==========");
        service.doTransaction(false);

        System.out.println("\n========== 실패 처리 ==========");
        try {
            service.doTransaction(true);
        } catch (Exception e) {
            System.out.println("예외 처리 완료");
        }

        context.close();
    }
}
