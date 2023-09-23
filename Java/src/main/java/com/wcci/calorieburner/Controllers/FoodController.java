package com.wcci.calorieburner.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Repositories.FoodRepository;
import com.wcci.calorieburner.Services.FoodService;
import com.wcci.calorieburner.Services.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping({"","/","/food"})
    public String getAllPublishers(Model model){
        model.addAttribute("foods", foodService.getAll());
        return "index";
    }

    // @GetMapping("/{id}")
    // public FoodModel getFoodById(@PathVariable Long id) {
    //     return foodRepository.findById(id)
    //             .orElseThrow(() -> new PetNotFoundException(id));
    // }

    /* @GetMapping("/{id}")
    public ResponseEntity<FoodModel> getFoodById(@PathVariable Long id) {
    Optional<FoodModel> food = foodService.findById(id);
        return food.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public FoodModel addFood(@RequestBody FoodModel food) {
        return foodService.save(food);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodService.deleteById(id);
    } */
}