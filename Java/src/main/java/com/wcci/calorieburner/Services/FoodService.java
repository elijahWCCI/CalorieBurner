package com.wcci.calorieburner.Services;

import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Models.UserModel;
import com.wcci.calorieburner.Repositories.FoodRepository;

public class FoodService {
        
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
           

        public void deleteFood(Long id) {
            foodRepository.findById(id).get();
            foodRepository.deleteById(id);
           }
}