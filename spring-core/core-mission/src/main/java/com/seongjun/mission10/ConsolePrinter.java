package com.seongjun.mission10;

import org.springframework.stereotype.Component;

@Component("consolePrinter")
public class ConsolePrinter implements Printer {
    @Override
    public void print(String message){
        System.out.println("[콘솔] " + message);
    }
}
