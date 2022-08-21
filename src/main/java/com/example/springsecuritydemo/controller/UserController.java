package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.model.User;
import com.example.springsecuritydemo.service.PostService;
import com.example.springsecuritydemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class UserController {
    private UserService userService;
    private PostService postService;

    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId){
        return userService.getById(userId);
    }



    @PostMapping("/users")
    public List<User> saveUsers(@RequestBody List<User> users){
        return userService.saveAll(users);
    }
}
