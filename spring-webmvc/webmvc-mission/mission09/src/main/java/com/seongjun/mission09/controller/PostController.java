package com.seongjun.mission09.controller;

import com.seongjun.mission09.model.Post;
import com.seongjun.mission09.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {

    public final PostService service;

    public PostController(PostService service){
        this.service = service;
    }

    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("post", new Post());
        return "new";
    }

    @PostMapping
    public String submitPost(@ModelAttribute Post post){
        service.createPost(post);
        return "redirect:/posts";
    }

    @GetMapping
    public String listPosts(Model model){
        model.addAttribute("posts", service.getAllPosts());
        return "list";
    }
}
