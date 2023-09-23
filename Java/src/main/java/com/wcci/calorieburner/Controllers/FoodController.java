package com.wcci.calorieburner.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Services.FoodService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;


    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

        // Create a new user
    @PostMapping("/addfood")
    public String addFood(
        @RequestParam String foodName,
        @RequestParam String imageurl,
        @RequestParam String foodCategory,
        @RequestParam int calories,
        Model page
    ) {
        if(foodName.isBlank() || imageurl.isBlank() || calories == 0 || foodCategory.isBlank()) {
            page.addAttribute("invalidInfo", "Please enter correct information to add food, including numbers above 0");
            return "errorAddFood.html";
        }
        FoodModel food = new FoodModel(foodName, calories, imageurl, foodCategory);
        foodService.saveFood(food);
        var foods = foodService.findAll();
        page.addAttribute("food", foods);
        return "index.html";
    }


    // Get a list of all users
    @GetMapping({"", "/", "/home"})
    public String home(Model page) {
        var foods = foodService.findAll();
        page.addAttribute("foods", foods);
        return "index.html";
    }


    @PostMapping("/delete")
    public String deleteFood(
        @RequestParam Long deleteId,
        Model page  
    ) {
        foodService.deleteFood(deleteId);
        var foods = foodService.findAll();
        page.addAttribute("foods", foods);
        return "index.html";
    }

    
    @ExceptionHandler(NoSuchElementException.class)
    public String errorOnDelete(HttpServletRequest request, Exception ex, Model page) {
        String invalidId = request.getParameter("deleteId");
        page.addAttribute("invalidId", invalidId);
        return "errorFoodID.html";
    }

    // @GetMapping
    // public List<FoodModel> getAllFoods() {
    //     return Streamable.of(foodRepository.findAll()).toList();
    // }

    // // @GetMapping("/{id}")
    // // public FoodModel getFoodById(@PathVariable Long id) {
    // //     return foodRepository.findById(id)
    // //             .orElseThrow(() -> new PetNotFoundException(id));
    // // }

    // @GetMapping("/{id}")
    // public ResponseEntity<FoodModel> getFoodById(@PathVariable Long id) {
    // Optional<FoodModel> food = foodRepository.findById(id);
    //     return food.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // @PostMapping
    // public FoodModel addFood(@RequestBody FoodModel food) {
    //     return foodRepository.save(food);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteFood(@PathVariable Long id) {
    //     foodRepository.deleteById(id);
    // }
}