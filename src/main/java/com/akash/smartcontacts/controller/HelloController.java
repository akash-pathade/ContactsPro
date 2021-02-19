package com.akash.smartcontacts.controller;

import com.akash.smartcontacts.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("home")
    public String home(){

//        User user = new User();
//        user.setName("Akash");
//        user.setAbout("Hi this is akash");
//        userRepository.save(user);
        return "home";
    }

    @GetMapping("about")
    public String about(){

//        User user = new User();
//        user.setName("Akash");
//        user.setAbout("Hi this is akash");
//        userRepository.save(user);
        return "about";
    }
}
