package com.seongjun.mission04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "손님") String name, Model model) {
        model.addAttribute("username", name);
        return "hello";
    }
}
