package com.seongjun.mission06.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public String admin() {
        return  "관리자 페이지 : 접근 허용됨";
    }
}
