package com.seongjun.mission09.controller;

import com.seongjun.mission09.model.Post;
import com.seongjun.mission09.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("post", new Post());
        return "new"; // templates/new.html
    }

    @PostMapping
    public String submitPost(@ModelAttribute Post post){
        postService.createPost(post);
        return "redirect:/posts";
    }

    @GetMapping
    public String listPosts(Model model){
        model.addAttribute("posts", postService.getAllPosts());
        return "list"; // templates/list.html
    }

    @GetMapping("/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "detail"; // templates/detail.html
    }
}
