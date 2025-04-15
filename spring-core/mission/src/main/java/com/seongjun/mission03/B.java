package com.seongjun.mission03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
    A a;
    @Autowired
    public void setA(A a){
        this.a = a;
    }
    public String callA() {
        return "B calls " + a.getName() + " (fixde)";
    }
    public String getName(){
        return "B (fixed)";
    }
}
