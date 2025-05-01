package com.seongjun.mission08.controller;

import com.seongjun.mission08.service.UserService;
import com.seongjun.mission08.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/sumbit")
    public String submitForm(@ModelAttribute User user) {
        service.addUser(user);
        return "redirect:/user";
    }

    @GetMapping("/users")
    public String listUsers(Model model){
        model.addAttribute("userList", service.getAllUsers());
        return "list";
    }
}
