package com.seongjun.mission06.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "홈페이지 : 누구나 접근 가능";
    }
}
