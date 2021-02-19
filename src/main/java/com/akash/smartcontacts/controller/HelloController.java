package com.akash.smartcontacts.controller;

import com.akash.smartcontacts.dao.UserRepository;
import com.akash.smartcontacts.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/doRegister")
    public String doRegister(@ModelAttribute("user") User user, @RequestParam(value = "agreement", defaultValue = "false") boolean isAgree,
                             Model model) {
        System.out.println(isAgree);
        System.out.println(user);
        return "index";
    }
}
