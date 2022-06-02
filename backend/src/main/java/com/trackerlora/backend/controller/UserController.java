package com.trackerlora.backend.controller;

import java.util.HashMap;
import java.util.Map;

import com.trackerlora.backend.entity.User;
import com.trackerlora.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping()
    public Map<String, Object> getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("username", authentication.getName());
        userMap.put("error", false);
        return userMap;
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping()
    public User updateUser(@PathVariable int uuid, @RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping()
    public void deleteUser(@PathVariable("uuid") String uuid) {
        repository.deleteByUuid(uuid);
    }


}
