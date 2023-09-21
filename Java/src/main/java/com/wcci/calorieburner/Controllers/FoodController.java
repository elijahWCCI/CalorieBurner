package com.wcci.calorieburner.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Repositories.FoodRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Foods")
public class FoodController {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping
    public List<FoodModel> getAllFoods() {
        return Streamable.of(foodRepository.findAll()).toList();
    }

    // @GetMapping("/{id}")
    // public FoodModel getFoodById(@PathVariable Long id) {
    //     return foodRepository.findById(id)
    //             .orElseThrow(() -> new PetNotFoundException(id));
    // }

    @GetMapping("/{id}")
    public ResponseEntity<FoodModel> getFoodById(@PathVariable Long id) {
    Optional<FoodModel> food = foodRepository.findById(id);
        return food.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public FoodModel addFood(@RequestBody FoodModel food) {
        return foodRepository.save(food);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodRepository.deleteById(id);
    }
}