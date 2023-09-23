package com.wcci.calorieburner.Services;

import org.springframework.stereotype.Service;

import com.wcci.calorieburner.Models.UserModel;
import com.wcci.calorieburner.Repositories.ExerciseRepository;
import com.wcci.calorieburner.Repositories.FoodRepository;
import com.wcci.calorieburner.Repositories.UserRepository;

import jakarta.annotation.Resource;

@Service
public class UserService {

        @Resource
        private UserRepository userRepository;
        @Resource
        private FoodRepository foodRepository;
        @Resource
        private ExerciseRepository exerciseRepository;

        public UserService(UserRepository userRepository, FoodRepository foodRepository, ExerciseRepository exerciseRepository) {
            this.userRepository = userRepository;
            this.foodRepository = foodRepository;
            this.exerciseRepository = exerciseRepository;
        }

        public UserModel saveUser(UserModel userModel) {
            return userRepository.save(userModel);
        }

        public boolean magicFormula() {
            //TODO
            //get the foods the user picks using repo

            //get the exercises the user picks using repo

            //with all that information run the formula
            //using the result from the formula, determine it meets the threshhold for success or failure
            //return true if successful, return false if unsuccessful in weight goals

            return false;
        }
}
