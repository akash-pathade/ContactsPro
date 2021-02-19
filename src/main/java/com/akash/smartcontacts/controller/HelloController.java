package com.akash.smartcontacts.controller;

import com.akash.smartcontacts.dao.UserRepository;
import com.akash.smartcontacts.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("hello")
    public String hello(){

        User user = new User();
        user.setName("Akash");
        user.setAbout("Hi this is akash");
        userRepository.save(user);
        return "Hello World";
    }
}
