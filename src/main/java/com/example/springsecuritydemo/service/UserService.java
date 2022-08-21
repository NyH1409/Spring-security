package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.model.User;
import com.example.springsecuritydemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public Optional<User> getById(Long userId){
        return repository.findById(userId);
    }

    public List<User> getAll(){
        return repository.findAll();
    }

    @Transactional
    public List<User> saveAll(List<User> users){
        return repository.saveAll(users);
    }
}
