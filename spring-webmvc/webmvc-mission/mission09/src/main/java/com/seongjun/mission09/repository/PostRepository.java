package com.seongjun.mission09.repository;

import com.seongjun.mission09.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    private final List<Post> postList = new ArrayList<>();
    private Long idCounter = 1L;

    public void save(Post post) {
        post.setId(idCounter++);
        postList.add(post);
    }

    public List<Post> findAll() {
        return postList;
    }

    public Post findById(Long id) {
        return postList.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
