package com.seongjun.mission10.controller;

import com.seongjun.mission10.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {
    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupProcess(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            userService.signup(username, password);
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            return "redirect:/signup?error=" + e.getMessage();
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
}