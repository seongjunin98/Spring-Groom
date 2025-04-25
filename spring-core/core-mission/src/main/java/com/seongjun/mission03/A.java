package com.seongjun.mission03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class A {
    B b;
    @Autowired
    public void setB(B b) {
        this.b = b;
    }
    public String callB() {
        return "A calls " + b.getName() + " (fixed)";
    }
    public String getName() {
        return "A (fixed)";
    }
}