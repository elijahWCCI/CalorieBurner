package com.wcci.calorieburner.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcci.calorieburner.Repositories.UserRepository;

import jakarta.annotation.Resource;

@Controller
public class UserController {
    
    @Resource
    private UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }


   /*  @RequestMapping({"","/","/calorieburner"})
    public String getAllPublishers(Model model){
        model.addAttribute("user", repository.findAll());
        return "displayPublisherView";
    } */
}
