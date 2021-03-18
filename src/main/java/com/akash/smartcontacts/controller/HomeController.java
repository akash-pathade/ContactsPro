package com.akash.smartcontacts.controller;

import com.akash.smartcontacts.dao.UserRepository;
import com.akash.smartcontacts.entities.User;
import com.akash.smartcontacts.helper.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    private static final String TITLE ="title";
    private static final String SIGNUP ="signup";

    @GetMapping({"home", "index"})
    public String home(Model model) {
        model.addAttribute(TITLE, "Smart Contact Manager | Home");
        return "index";
    }

    @GetMapping("about")
    public String about(Model model) {
        model.addAttribute(TITLE, "Smart Contact Manager | About");
        return "about";
    }

    @GetMapping({"signin", "login", "log-in"})
    public String login(Model model) {
        model.addAttribute(TITLE, "Smart Contact Manager | login");
        return "login";
    }

    @GetMapping(SIGNUP)
    public String signup(Model model) {
        model.addAttribute(TITLE, "Smart Contact Manager | signup");
        model.addAttribute("user", new User());
        return SIGNUP;
    }

    @PostMapping("/doRegister")
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult results,
                             @RequestParam(value = "agreement", defaultValue = "false") boolean isAgree,
                             Model model, HttpSession session) {
        try {

//            This is to check if the form has any validation errors or not
            if (results.hasErrors()) {
                model.addAttribute("user", user);
                return SIGNUP;
            }

            if (!isAgree) {
                throw new Exception("You have not accepted terms and Condition");
            }

            user.setEnabled(true);
            user.setImageURL("default_profile.png");
            user.setRole("ROLE_USER");
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            userRepository.save(user);
            model.addAttribute("user", new User());
            session.setAttribute("message", new Message("Successfully registered " + user.getName() + "!!", "alert-success"));

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message", new Message("Something went wrong: " + e.getMessage() + " !!", "alert-danger "));
        }

        return SIGNUP;
    }
}
