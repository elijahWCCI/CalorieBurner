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
        CalculateCaloriesDto calculate = new CalculateCaloriesDto(0, 0, 0, 0, false, null, food, exercise);
        model.addAttribute("calculator", calculate);
        return "CalorieView";
    }

    @PostMapping("calculator")
    public String calculator(@ModelAttribute("calculator") CalculateCaloriesDto calculator) {
        // int currentWeight = calculator.getCurrentWeight();
        // int targetWeight = calculator.getTargetWeight();
        // int weightDifference = currentWeight - targetWeight;
        // int acceptableRange = 2;

        int totalCaloriesFromFood = 0;
        int totalCaloriesBurnedFromExercise = 0;

        for (FoodModel foodModel : calculator.getFood()) {
            totalCaloriesFromFood = totalCaloriesFromFood + foodModel.getCalories();
        }

        for (ExerciseModel exerciseModel : calculator.getExercise()) {
            totalCaloriesBurnedFromExercise = totalCaloriesBurnedFromExercise + exerciseModel.getCaloriesBurned();
        }

        if (totalCaloriesBurnedFromExercise > totalCaloriesFromFood) {
            return "GoodBurnView";
        } else {
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

}