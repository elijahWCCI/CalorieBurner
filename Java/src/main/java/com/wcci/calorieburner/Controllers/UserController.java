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
                0, 0, 0, 0, false, null, foodService.findAll(), exerciseService.findAll());
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

        /*
         * for(SelectedFoodDto dto: calculator.getUserFoodSelected()) {
         * System.out.println("########################");
         * System.out.println("====>"+dto.getFoodId());
         * System.out.println("====>"+dto.getQuantity());
         * System.out.println("########################"); }
         */

        // for(SelectedExerciseDto dto: calculator.getUserSelectedExercise()) {
        // System.out.println("########################");
        // System.out.println("====>"+dto.getExerciseId());
        // System.out.println("########################");
        // }
        // if (params.containsKey("addToFoodList")) {
        // // Handle logic to add to the list of selected food with quantity
        // long foodId = Long.parseLong((String) params.get("foodSelection"));
        // int foodQuantity = Integer.parseInt((String) params.get("foodQuantity"));
        // calculator.addToSelectedFoods(foodService.getByFoodId(foodId), foodQuantity);
        // return "redirect:/user";
        // } else if (params.containsKey("addToExerciseList")) {
        // // Handle logic to add to the list of selected exercises with quantity
        // long exerciseId = Long.parseLong((String) params.get("exerciseSelection"));
        // int exerciseQuantity = Integer.parseInt((String)
        // params.get("exerciseQuantity"));
        // calculator.addToSelectedExercises(exerciseService.getExerciseById(exerciseId),
        // exerciseQuantity);
        // return "redirect:/user";
        // } else if (params.containsKey("submitForm")) {
        // // Handle regular form submission logic
        // if (calculatorCaloriesService.secretFormula(calculator)) {
        // return "BadBurnView";
        // }
        // return "GoodBurnView";
        // }

        if (calculatorCaloriesService.secretFormula(calculator)) {
            return "GoodBurnView";
        }
        return "BadBurnView";

        // return "redirect:/error";
    }
}