package com.seongjun.mission06;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class WelcomeService implements MessageService {
    @Override
    public String getMessage() {
        return "안녕하세요!";
    }

}
