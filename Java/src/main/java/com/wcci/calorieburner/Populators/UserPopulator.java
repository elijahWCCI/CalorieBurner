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
public class UserPopulator implements CommandLineRunner {

    @Resource
    private UserRepository uRepository;





    public UserPopulator(UserRepository uRepository) {
        this.uRepository = uRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        UserModel foodCategory1 = new UserModel("Grains");
        uRepository.save(foodCategory1);
        UserModel foodCategory2 = new UserModel("Vegetables (Raw)");
        uRepository.save(foodCategory2);
        UserModel foodCategory3 = new UserModel("Fruits");
        uRepository.save(foodCategory3);
        UserModel foodCategory4 = new UserModel("Dairy");
        uRepository.save(foodCategory4);
        UserModel foodCategory5 = new UserModel("Proteins");
        uRepository.save(foodCategory5);

    }

}
