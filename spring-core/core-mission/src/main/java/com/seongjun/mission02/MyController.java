package com.seongjun.mission02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyController {

    @Autowired
    private MyService myService;

    public void execute(){
        String result = myService.doSomething();
        System.out.println("결과 : " + result);
    }
}
