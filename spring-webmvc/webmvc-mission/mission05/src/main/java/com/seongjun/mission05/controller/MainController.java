package com.seongjun.mission05.controller;

import com.seongjun.mission05.dto.UserForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/*")
    public String showForm(Model model){
        model.addAttribute("userForm", new UserForm());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute UserForm userForm, BindingResult result, Model model) {
        if (result.hasErrors()){
            throw new IllegalArgumentException("유효성 검사 실패");
        }
        model.addAttribute("username", userForm.getName());
        return "result";
    }
}
