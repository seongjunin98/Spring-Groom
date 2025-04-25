package com.seongjun.mission04;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    private String data = "초기 데이터";

    public PrototypeBean() {
        System.out.println("프로토타입 생성");
    }

    public void setData(String data) {
        this.data =data;
    }

    public String getData(){
        return data;
    }

}
