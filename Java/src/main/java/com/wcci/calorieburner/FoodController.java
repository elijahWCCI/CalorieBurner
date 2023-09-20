package com.wcci.calorieburner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Foods")
public class FoodController {

    private final FoodRepository foodRepository;

    @Autowired
    public VirtualPetController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }

    @PostMapping
    public Food addFood(@RequestBody Food food) {
        return foodRepository.save(food);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodRepository.deleteById(id);
    }
}
