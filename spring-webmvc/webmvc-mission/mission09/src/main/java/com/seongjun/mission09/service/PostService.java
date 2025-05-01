package com.seongjun.mission09.service;

import com.seongjun.mission09.model.Post;
import com.seongjun.mission09.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public void createPost(Post post) {
        repository.save(post);
    }

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public Post getPostById(Long id) {
        return repository.findById(id);
    }
}
