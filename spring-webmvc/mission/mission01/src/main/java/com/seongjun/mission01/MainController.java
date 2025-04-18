package com.seongjun.mission01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String groom(Model model){

        model.addAttribute("name", "성준");

        return "groom";
    }
}
