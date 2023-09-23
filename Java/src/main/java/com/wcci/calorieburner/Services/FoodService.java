package com.wcci.calorieburner.Services;

import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Repositories.FoodRepository;

public class FoodService {
        
    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Iterable<FoodModel> getAll() {
        return foodRepository.findAll();
    }
}