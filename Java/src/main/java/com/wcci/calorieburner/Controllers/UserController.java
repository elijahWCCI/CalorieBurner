package com.wcci.calorieburner.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wcci.calorieburner.Models.CalculateCaloriesDto;
import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Models.FoodModel;
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

    public UserController(FoodService foodService, ExerciseService exerciseService, CalculatorCaloriesService calculatorCaloriesService) {
        this.foodService = foodService;
        this.exerciseService = exerciseService;
        this.calculatorCaloriesService = calculatorCaloriesService;
    }

    @GetMapping("/user")
    public String home(Model model) {
        Iterable<FoodModel> food = foodService.findAll();
        Iterable<ExerciseModel> exercise = exerciseService.findAll();
        calculator = new CalculateCaloriesDto(0, 0, 0, 0, false, null, food, exercise);
        model.addAttribute("calculator", calculator);
        return "CalorieView";
    }

    @PostMapping("/calculator")
    public String Calculator(@ModelAttribute("calculator") CalculateCaloriesDto calculator,
                            @RequestParam String name,
                            @RequestParam  boolean gender,
                            @RequestParam  int age,
                            @RequestParam int currentWeight,
                            @RequestParam int targetWeight){
        System.out.println(name);
        System.out.println(gender);
        System.out.println(age);
        System.out.println(currentWeight);
        System.out.println(targetWeight);
        if(calculatorCaloriesService.secretFormula(calculator)) {
            return "BadBurnView";
        }

        return "GoodBurnView";
    }

    @PostMapping("/addFood")
    public String addFood(Model model,@RequestParam Long id) {
        calculator.addFood(id);
        model.addAttribute("calculator", calculator);
        return "CalorieView";
    }


    @PostMapping("/addExercise")
    public String addExercise(Model model,@RequestParam Long id){
        calculator.addExercise(id);
        model.addAttribute("calculator", calculator);
        System.out.println(calculator.getExerciseList());
        return "CalorieView";
    }


    //juansBranch

}