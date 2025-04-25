package com.seongjun.mission04;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    private String data = "초기 데이터";

    public SingletonBean() {
        System.out.println("싱글톤 생성");

    }
    public void setData(String data){
        this.data = data;
    }

    public String getData() {
        return  data;
    }
}
