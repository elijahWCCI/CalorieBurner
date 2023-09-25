package com.wcci.calorieburner.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcci.calorieburner.Models.CalculateCaloriesDto;
import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Services.ExerciseService;
import com.wcci.calorieburner.Services.FoodService;

@Controller
@RequestMapping("/user")
public class UserController {

    private FoodService foodService;
    private ExerciseService exerciseService;

    public UserController(FoodService foodService, ExerciseService exerciseService) {
        this.foodService = foodService;
        this.exerciseService = exerciseService;
    }

    @RequestMapping("")
    public String home(Model model) {
        Iterable<FoodModel> food = foodService.findAll();
        Iterable<ExerciseModel> exercise = exerciseService.findAll();
        CalculateCaloriesDto calculate = new CalculateCaloriesDto(0, 0, 0, 0, false, null,food, exercise);
        model.addAttribute("calculator", calculate);
        return "CalorieView";
    }

    @PostMapping("calculator")
    public String Calculator(@ModelAttribute("calculator") CalculateCaloriesDto calculator) {

        if(calculator.getName().contains("k")) {
            return "BadBurnView";
        }

        return "GoodBurnView";
    }


    //stevens branch

}