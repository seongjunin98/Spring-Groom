package com.seongjun.mission02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String redirect() {

        return "redirect:/form";
    }

    @GetMapping("/form")
    public String showForm(Model model) {

        model.addAttribute("user", new UserDTO());

        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute UserDTO user, Model model) {

        model.addAttribute("user", user);

        return "result";
    }
}
