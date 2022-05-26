package com.trackerlora.backend.controller;

import java.util.List;

import com.trackerlora.backend.entity.User;
import com.trackerlora.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(path = "/users")
    public List<User> allUsers() {
        return (List<User>) repository.findAll();
    }

    @GetMapping(path = "/users/{name}")
    public List<User> findByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    @PostMapping(path = "/user")
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping(path = "/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
