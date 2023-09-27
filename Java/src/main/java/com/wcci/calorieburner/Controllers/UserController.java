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
import com.wcci.calorieburner.Services.CalculatorCaloriesService;
import com.wcci.calorieburner.Services.ExerciseService;
import com.wcci.calorieburner.Services.FoodService;

@Controller
@RequestMapping("/user")
public class UserController {

    private FoodService foodService;
    private ExerciseService exerciseService;
    private CalculatorCaloriesService calculatorCaloriesService;

    public UserController(FoodService foodService, ExerciseService exerciseService,
            CalculatorCaloriesService calculatorCaloriesService) {
        this.foodService = foodService;
        this.exerciseService = exerciseService;
        this.calculatorCaloriesService = calculatorCaloriesService;
    }

    @RequestMapping("")
    public String home(Model model) {
        Iterable<FoodModel> food = foodService.findAll();
        Iterable<ExerciseModel> exercise = exerciseService.findAll();
        CalculateCaloriesDto calculate = new CalculateCaloriesDto(0, 0, 0, 0, false, null, food, exercise);
        model.addAttribute("calculator", calculate);
        return "CalorieView";
    }

    @PostMapping("calculator")
    public String Calculator(@ModelAttribute("calculator") CalculateCaloriesDto calculator) {

        if (calculatorCaloriesService.secretFormula(calculator)) {
            return "BadBurnView";
        }

        // double calculateBMI = calculateBMI(calculator.getCurrentHeight(),
        // calculator.getCurrentWeight());
        // if(calculateBMI <=18.5) {
        // return "GoodBurnView";
        // } else if(calculateBMI >=18.5 && calculateBMI <=24.9) {
        // return "GoodBurnView";
        // } else if(calculateBMI >=25) {
        // return "BadBurnView";
        // } else {
        // return "BadBurnView";
        // }
        //

        // if (Math.abs(weightDifference) <= acceptableRange) {
        // return "GoodBurnView";
        // } else {
        // return "BadBurnView";
        // }
    }

    // private double calculateBMI(double height, double weight) {
    // return weight / (height * height);
    // }

    // stevens branch

    // kylesBranch

    // kylesBranch

}