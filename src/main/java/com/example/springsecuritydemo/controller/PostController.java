package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.model.Post;
import com.example.springsecuritydemo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
public class PostController {
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts(){
        return postService.getAll();
    }

    @GetMapping("/posts/{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postService.getById(postId);
    }

    @PostMapping("/posts")
    public List<Post> savePosts(@RequestBody List<Post> posts){
        return postService.saveAll(posts);
    }

    @GetMapping("/users/{userId}/posts")
    public List<Post> getUserPosts(@PathVariable Long userId){
        return postService.getPostsByUserId(userId);
    }
}
