package com.wcci.calorieburner.Services;

import org.springframework.stereotype.Service;

import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Repositories.FoodRepository;

import jakarta.annotation.Resource;

@Service
public class FoodService {
    @Resource
    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public FoodModel saveFood(FoodModel foodModel) {
        return foodRepository.save(foodModel);
    }

    public Iterable<FoodModel> findAll() {
        return foodRepository.findAll();
    }

    public FoodModel findFoodById(Long id) {
        return foodRepository.findById(id).get();
    }

    public FoodModel getByFoodId(Long id) {
        return foodRepository.findById(id).get();
    }
}