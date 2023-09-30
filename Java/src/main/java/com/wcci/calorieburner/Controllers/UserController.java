package com.wcci.calorieburner.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wcci.calorieburner.Models.CalculateCaloriesDto;
import com.wcci.calorieburner.Models.SelectedExerciseDto;
import com.wcci.calorieburner.Models.SelectedFoodDto;
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
        CalculateCaloriesDto calculate = new CalculateCaloriesDto(
                0, 0, 0, false, null, foodService.findAll(), exerciseService.findAll());
        model.addAttribute("calculator", calculate);
        return "CalorieView";
    }
    //
    // @PostMapping("addFoodListToUser")
    // public String saveFoodListByUser(@ModelAttribute("foodList") SelectedFoodDto
    // foodDto) {
    //
    //
    // return "CalorieView";
    // }

    @PostMapping("calculator")
    public String Calculator(
            @ModelAttribute("calculator") CalculateCaloriesDto calculator,
            @RequestParam Map<String, Object> params) {

        if (calculatorCaloriesService.secretFormula(calculator)) {
            return "GoodBurnView";
        }
        return "BadBurnView";

        // return "redirect:/error";

        //kyle branch
    }
}