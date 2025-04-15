package com.seongjun.mission02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    /* 목표. Spring 프레임워크에서 애너테이션(@Autowired, @Inject 등)을 사용하여 빈을 주입합니다. 애너테이션을 이용하여 빈 의존성을 설정하고, 해당 방식으로 빈을 주입하는 코드를 작성합니다. 애너테이션으로 주입된 빈이 올바르게 동작하는지 확인하기 위해 실행 결과를 확인합니다. 결과물로 애너테이션으로 주입된 빈의 실행 결과 스크린샷을 제출.
       * 1. Service 클래스를 Spring 컴포넌트 빈으로 등록
       * 2. Controller 클래스를 Spring의 컴포넌트 빈으로 등록
       * 3. Controller를 Service 타입의 빈에 자동 주입
       * 4. 스캔을 통해 패키지를 지정하고 빈으로 등록
       * 5. Spring 컨테이너를 초기화 하고 Controller 빈을 가져와 메서드 호출
    * */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MyController controller = context.getBean(MyController.class);
        controller.execute();

        context.close();
    }
}
