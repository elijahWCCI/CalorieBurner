package com.wcci.calorieburner.Services;

import org.springframework.stereotype.Service;

import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Repositories.FoodRepository;

@Service
public class FoodService {
        
    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Iterable<FoodModel> getAll() {
        return foodRepository.findAll();
    }
}