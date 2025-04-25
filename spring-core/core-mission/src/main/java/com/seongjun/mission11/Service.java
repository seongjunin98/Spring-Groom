package com.seongjun.mission11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {

    private final MessageService service;

    @Autowired

    public Service(MessageService service) {
        this.service = service;
    }

    public void process() {
        service.sendMessage("메시지를 보냅니다.");
    }
}

