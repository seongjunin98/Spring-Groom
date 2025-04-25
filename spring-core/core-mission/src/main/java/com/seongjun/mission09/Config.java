package com.seongjun.mission09;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:mission09/application.properties")
public class Config {

    @Value("${my.app.name}")
    private String appName;

    @Value("${my.app.version}")
    private String appVersion;

    @Value("${my.greeting.message}")
    private String greetingMessageTemplate;

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getGreetingMessage(String name) {
        return greetingMessageTemplate.replace("{name}", name);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
