package com.seongjun.mission05;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int add(int a, int b) {
        System.out.println("더하기 연산 : " + a + " + " + b);
        return a + b;
    }

    public int subtract(int a, int b) {
        System.out.println("빼기 연산 : " + a + " - " + b);
        return a - b;
    }


}
