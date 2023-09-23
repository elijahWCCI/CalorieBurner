package com.wcci.calorieburner.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcci.calorieburner.Repositories.FoodRepository;

import jakarta.annotation.Resource;

@Controller
public class FoodController {
    
    @Resource
    private FoodRepository repository;

    public FoodController(FoodRepository repository){
        this.repository = repository;
    }


    @RequestMapping({ "", "/", "/calorieburner" })
    public String getAllFoods(Model model) {
        model.addAttribute("Foods", repository.findAll());
        return "index";
    }
}
