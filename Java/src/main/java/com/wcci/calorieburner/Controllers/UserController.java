package com.wcci.calorieburner.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wcci.calorieburner.Models.*;
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

    @PostMapping("/calculator")
    public String calculator(@ModelAttribute("calculator") CalculateCaloriesDto calculator,
            @RequestParam Map<String, Object> params) {

        List<SelectedFoodDto> userFoodSelected = calculator.getUserFoodSelected();
        List<SelectedExerciseDto> userSelectedExercise = calculator.getUserSelectedExercise();

        if (calculatorCaloriesService.secretFormula(calculator)) {
            return "GoodBurnView";
        }
        return "BadBurnView";

    }

    @RequestMapping("")
    public String home(Model model) {
        CalculateCaloriesDto calculate = new CalculateCaloriesDto(
                0, 0, 0, true, null, foodService.findAll(), exerciseService.findAll());
        model.addAttribute("calculator", calculate);
        return "CalorieView";
    }

}