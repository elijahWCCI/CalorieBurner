package com.wcci.calorieburner.Controllers;

import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wcci.calorieburner.Models.*;
import com.wcci.calorieburner.Repositories.UserRepository;
import com.wcci.calorieburner.Services.CalculatorCaloriesService;
import com.wcci.calorieburner.Services.ExerciseService;
import com.wcci.calorieburner.Services.FoodService;
import com.wcci.calorieburner.Services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private FoodService foodService;
    private ExerciseService exerciseService;
    private CalculatorCaloriesService calculatorCaloriesService;
    private CalculateCaloriesDto userInfo;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public UserController(FoodService foodService, ExerciseService exerciseService,
            CalculatorCaloriesService calculatorCaloriesService) {
        this.foodService = foodService;
        this.exerciseService = exerciseService;
        this.calculatorCaloriesService = calculatorCaloriesService;
    }

<<<<<<< HEAD
    @PostMapping("/home/calculator")
=======
    @PostMapping("/calculator")
>>>>>>> 270a8aff13fc6c3664d789b23deba2564f7cee23
    public String calculator(@ModelAttribute("calculator") CalculateCaloriesDto calculator,
            @RequestParam Map<String, Object> params) {

        List<SelectedFoodDto> userFoodSelected = calculator.getUserFoodSelected();
        List<SelectedExerciseDto> userSelectedExercise = calculator.getUserSelectedExercise();

        if (calculatorCaloriesService.secretFormula(calculator)) {
            return "GoodBurnView";
        }
        return "BadBurnView";

    }

    @RequestMapping("/home")
    public String home(Model model) {
<<<<<<< HEAD
       /*  CalculateCaloriesDto userInfo = new CalculateCaloriesDto(
                this.userInfo.getCurrentWeight(), this.userInfo.getAge(), this.userInfo.getCurrentHeight(),
                this.userInfo.isGender(), this.userInfo.getName(), foodService.findAll(), exerciseService.findAll()); */
        userInfo.updateExerciceList(exerciseService.findAll());
        userInfo.updateFoodList(foodService.findAll());
=======
        CalculateCaloriesDto userInfo = new CalculateCaloriesDto(
                this.userInfo.getCurrentWeight(), this.userInfo.getAge(), this.userInfo.getCurrentHeight(), this.userInfo.isGender(), this.userInfo.getName(), foodService.findAll(), exerciseService.findAll());
>>>>>>> 270a8aff13fc6c3664d789b23deba2564f7cee23
        model.addAttribute("calculator", userInfo);
        return "CalorieView";
    }

    @GetMapping("/info")
    public String login(Model model) {
        return "login.html";
    }

    @PostMapping("/login")
    public String addUser(Model model,
            @RequestParam String userName,
            @RequestParam String password) {
<<<<<<< HEAD
                
        userInfo = new CalculateCaloriesDto(0, 0, 0, true, null, foodService.findAll(), exerciseService.findAll());        
        model.addAttribute("username", userName);
        model.addAttribute("password", password);
        userInfo = userService.findUserByCredentials(userInfo, userName, password);
=======
        userInfo = new CalculateCaloriesDto(
                0, 0, 0, true, null, foodService.findAll(), exerciseService.findAll());

        model.addAttribute("username", userName);
        model.addAttribute("password", password);
        userInfo = userService.findUserByCredentials(userInfo, userName,password);
>>>>>>> 270a8aff13fc6c3664d789b23deba2564f7cee23
        System.out.println(userInfo);
        if (userInfo != null) {
            model.addAttribute("calculator", userInfo);
            return "CalorieView.html";
        } else {
            return "WrongCredentials";
        }

<<<<<<< HEAD
        // userInfo.createUser(userName, password);
=======
       // userInfo.createUser(userName, password);
>>>>>>> 270a8aff13fc6c3664d789b23deba2564f7cee23
        /*
         * User newUser = new User();
         * newUser.createUser(userName, password);
         * userRepository.save(newUser);
         */

    }

}