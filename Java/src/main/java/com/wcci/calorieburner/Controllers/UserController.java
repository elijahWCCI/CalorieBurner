package com.wcci.calorieburner.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wcci.calorieburner.Models.CalculateCaloriesDto;
import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Models.SelectedExerciseDto;
import com.wcci.calorieburner.Models.SelectedFoodDto;
import com.wcci.calorieburner.Services.CalculatorCaloriesService;
import com.wcci.calorieburner.Services.ExerciseService;
import com.wcci.calorieburner.Services.FoodService;

@Controller

public class UserController {

    private FoodService foodService;
    private ExerciseService exerciseService;
    private CalculatorCaloriesService calculatorCaloriesService;
    private CalculateCaloriesDto calculator ;
    public Iterable<FoodModel> food;
    public Iterable<ExerciseModel> exercise;

    public UserController(FoodService foodService, ExerciseService exerciseService,
            CalculatorCaloriesService calculatorCaloriesService) {
        this.foodService = foodService;
        this.exerciseService = exerciseService;
        this.calculatorCaloriesService = calculatorCaloriesService;
    }

    @GetMapping("/user")
    public String home(Model model) {
        CalculateCaloriesDto calculate = new CalculateCaloriesDto(
                0, 0, 0, true, null, foodService.findAll(), exerciseService.findAll());
        model.addAttribute("calculator", calculate);
        return "CalorieView";
    }

    // @PostMapping("calculator")
    // public String Calculator(
    // @ModelAttribute("calculator") CalculateCaloriesDto calculator,
    // @RequestParam Map<String, Object> params) {

    // if (calculator.getUserFoodSelected().size() > 2) {
    // return "GoodBurnView";
    // }
    // return "BadBurnView";

    // }

    //
    // @PostMapping("addFoodListToUser")
    // public String saveFoodListByUser(@ModelAttribute("foodList") SelectedFoodDto
    // foodDto) {
    //
    //
    // return "CalorieView";
    // }

    @PostMapping("calculator")
    public String calculator(@ModelAttribute("calculator") CalculateCaloriesDto calculator,
            @RequestParam Map<String, Object> params) {
        List<SelectedFoodDto> userFoodSelected = calculator.getUserFoodSelected();
        List<SelectedExerciseDto> userSelectedExercise = calculator.getUserSelectedExercise();

        if (calculatorCaloriesService.secretFormula(calculator)) {
            return "GoodBurnView";
        }

        return "BadBurnView";
    }
    // @PostMapping("calculator")
    // public String calculator(@ModelAttribute("calculator") CalculateCaloriesDto
    // calculator,
    // @RequestParam Map<String, Object> params) {

    // if (calculator != null &&
    // calculatorCaloriesService.secretFormula(calculator)) {
    // List<SelectedFoodDto> userFoodSelected = calculator.getUserFoodSelected();
    // if (userFoodSelected != null && userFoodSelected.size() > 2) {
    // return "GoodBurnView";
    // }
    // }
    // return "BadBurnView";
    // }

    // if (calculator.getUserFoodSelected().size() > 2) {
    // return "GoodBurnView";
    // }
    // return "BadBurnView";
    // return "redirect:/error";


}