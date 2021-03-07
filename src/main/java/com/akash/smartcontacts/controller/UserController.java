package com.akash.smartcontacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping({"index","dashboard","home"})
    public String userDashboard(){
        return "user/dashboard";
    }
}
