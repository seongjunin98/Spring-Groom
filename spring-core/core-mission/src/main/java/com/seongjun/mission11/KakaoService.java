package com.seongjun.mission11;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class KakaoService implements MessageService{
    public void sendMessage(String msg){
        System.out.println("카카오톡 전송 : " + msg);
    }
}
