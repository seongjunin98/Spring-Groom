package com.seongjun.mission07;

public class MessagePrinter implements MessageService {
    private final WelcomeService welcomeService;

    public MessagePrinter(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @Override
    public String getMessage() {
        return "프린터 출력: " + welcomeService.getMessage();
    }

    public void printMessage() {
        System.out.println(getMessage());
    }
}