package com.akash.smartcontacts.controller;

import com.akash.smartcontacts.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("title", "Smart Contact Manager | Home");
        return "index";
    }

    @GetMapping("about")
    public String about(Model model) {
        model.addAttribute("title", "Smart Contact Manager | About");
        return "about";
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("title", "Smart Contact Manager | Home");
        return "index";
    }

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("title", "Smart Contact Manager | login");
        return "login";
    }

    @GetMapping("signup")
    public String signup(Model model) {
        model.addAttribute("title", "Smart Contact Manager | signup");
        return "signup";
    }
}
