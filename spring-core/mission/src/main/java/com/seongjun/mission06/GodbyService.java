package com.seongjun.mission06;

import org.springframework.stereotype.Component;

@Component

public class GodbyService implements MessageService{
    @Override
    public String getMessage(){
        return "안녕히 가세요!";
    }
}
