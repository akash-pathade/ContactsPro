package com.akash.smartcontacts.controller;

import com.akash.smartcontacts.dao.UserRepository;
import com.akash.smartcontacts.entities.User;
import com.akash.smartcontacts.helper.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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
                             Model model, HttpSession session) {
        try {
            if (!isAgree) {
                throw new Exception("You have not accepted terms and Condition");
            }

            user.setEnabled(true);
            user.setImageURL("default_profile.png");
            user.setRole("ROLE_USER");

            User savedUser = userRepository.save(user);
            model.addAttribute("user", new User());
            session.setAttribute("message", new Message("Successfully registered "+user.getName()+"!!","alert-success"));

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message", new Message("Something went wrong: " + e.getMessage() + " !!", "alert-danger"));
        }

        return "signup";
    }
}
