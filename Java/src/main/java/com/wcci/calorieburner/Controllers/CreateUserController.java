package com.wcci.calorieburner.Controllers;

import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wcci.calorieburner.Models.User;
import com.wcci.calorieburner.Repositories.UserRepository;

@Controller
public class CreateUserController {
    
   /*  @Autowired
    private UserRepository userRepository;

    @GetMapping("/info")
    public String login(Model model){
        return "login.html";

    }

    @PostMapping("/login")
    public String addUser(Model model,
    @RequestParam String userName,
    @RequestParam String password ){
        model.addAttribute("username", userName);
        model.addAttribute("password", password);
        User newUser = new User();
        newUser.createUser(userName, password);
        userRepository.save(newUser);
        return "login.html";
    } */
}
