package com.seongjun.mission07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public WelcomeService welcomeService(){
        return new WelcomeService();
    }

    @Bean
    public MessagePrinter printer(WelcomeService service){
        return new MessagePrinter(service);
    }
}