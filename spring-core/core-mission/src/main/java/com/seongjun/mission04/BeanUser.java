package com.seongjun.mission04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanUser {
    @Autowired SingletonBean s1;
    @Autowired SingletonBean s2;
    @Autowired PrototypeBean p1;
    @Autowired PrototypeBean p2;

    public void checkBean(){
        System.out.println("싱글톤 s1 : " + s1.getData());
        System.out.println("싱글톤 s2 : " + s2.getData());
        System.out.println("프로토타입 p1 데이터 : "  + p1.getData());
        System.out.println("프로토타입 p2 데이터 : "  + p2.getData());

        s1.setData("데이터 변경.");
        p1.setData("데이터 변경.");

        System.out.println("\n변경 후:");
        System.out.println("싱글톤 s1 데이터: " + s1.getData());
        System.out.println("싱글톤 s2 데이터: " + s2.getData());
        System.out.println("프로토타입 p1 데이터: " + p1.getData());
        System.out.println("프로토타입 p2 데이터: " + p2.getData());
    }

}
