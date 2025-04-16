package com.seongjun.mission08;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Bean {

    public Bean(){
        System.out.println("Bean 생성자 호출");
    }

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct 메서드 호출: 빈 초기화 완료");
    }

    public void doSomething(){
        System.out.println("Bean의 doSomething() 메서드 호출");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("@PreDestroy 메서드 호출 : 빈 소멸 전");
    }
}
