package com.wcci.calorieburner.Populators;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Models.FoodCategoryModel;
import com.wcci.calorieburner.Models.FoodModel;
//import com.wcci.calorieburner.Models.UserModel;
import com.wcci.calorieburner.Repositories.ExerciseRepository;
import com.wcci.calorieburner.Repositories.FoodCategoryRepository;
import com.wcci.calorieburner.Repositories.FoodRepository;
import com.wcci.calorieburner.Repositories.UserRepository;

import jakarta.annotation.Resource;

@Component
public class FoodCategoryPopulator implements CommandLineRunner {

    @Resource
    private FoodCategoryRepository fcRepository;





    public FoodCategoryPopulator(FoodCategoryRepository fcRepository) {
        this.fcRepository = fcRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        FoodCategoryModel foodCategory1 = new FoodCategoryModel("Grains");
        fcRepository.save(foodCategory1);
        FoodCategoryModel foodCategory2 = new FoodCategoryModel("Vegetables (Raw)");
        fcRepository.save(foodCategory2);
        FoodCategoryModel foodCategory3 = new FoodCategoryModel("Fruits");
        fcRepository.save(foodCategory3);
        FoodCategoryModel foodCategory4 = new FoodCategoryModel("Dairy");
        fcRepository.save(foodCategory4);
        FoodCategoryModel foodCategory5 = new FoodCategoryModel("Proteins");
        fcRepository.save(foodCategory5);

    }

}
