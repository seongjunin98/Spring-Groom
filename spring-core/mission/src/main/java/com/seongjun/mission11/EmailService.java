package com.seongjun.mission11;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {
    public void sendMessage(String msg){
        System.out.println("이메일 전송 : " + msg);
    }
}
