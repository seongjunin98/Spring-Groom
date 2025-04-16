package com.seongjun.mission10;

import org.springframework.stereotype.Component;

@Component("filePrinter")
public class FilePrinter implements Printer{
    @Override
    public void print(String message) {
        System.out.println("[파일] " + message + " (파일에 저장된 것 처럼 출력)");
    }
}
