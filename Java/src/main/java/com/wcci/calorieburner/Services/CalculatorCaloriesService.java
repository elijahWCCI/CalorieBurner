package com.wcci.calorieburner.Services;

import org.springframework.stereotype.Service;

import com.wcci.calorieburner.Models.CalculateCaloriesDto;
import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Models.FoodModel;

@Service
public class CalculatorCaloriesService {

    // Calculate TDEE and compare it with total calories from food
    public boolean secretFormula(CalculateCaloriesDto dto) {
        // Calculate TDEE using BMR and activity level
        double tdee = calculateTDEE(dto.getCurrentWeight(), dto.getCurrentHeight(), dto.getAge(), dto.isGender(),
                dto.getExercise());

        // Calculate total calories from food
        int totalCaloriesFromFood = calculateTotalCaloriesFromFood(dto.getFood());

        // Compare TDEE with total calories from food
        return tdee >= totalCaloriesFromFood;
    }

    // Calculate TDEE using BMR and activity level
    private static double calculateTDEE(double weightKg, double heightCm, int age, boolean gender,
            Iterable<ExerciseModel> exercises) {
        // Calculate BMR based on weight, height, age, and gender
        double bmr = calculateBMR(weightKg, heightCm, age, gender);

        // Calculate activity level based on exercises
        double activityLevel = calculateActivityLevel(exercises);

        // Calculate TDEE using BMR and activity level
        return calculateDailyCalorieNeeds(bmr, activityLevel);
    }

    // Calculate total calories from food
    private static int calculateTotalCaloriesFromFood(Iterable<FoodModel> foods) {
        int totalCaloriesFromFood = 0;

        // Sum up the calories from each food item
        for (FoodModel foodModel : foods) {
            totalCaloriesFromFood += foodModel.getCalories();
        }

        return totalCaloriesFromFood;
    }

    // Calculate BMR based on weight, height, age, and gender
    private static double calculateBMR(double weightKg, double heightCm, int age, boolean gender) {
        if (gender) {
            // BMR calculation for males
            return 88.362 + (13.397 * weightKg) + (4.799 * heightCm) - (5.677 * age);
        } else {
            // BMR calculation for females
            return 447.593 + (9.247 * weightKg) + (3.098 * heightCm) - (4.330 * age);
        }
    }

    // Calculate activity level based on average calories burned from exercises
    private static double calculateActivityLevel(Iterable<ExerciseModel> exercises) {
        int totalCaloriesBurnedFromExercise = 0;
        int count = 0;

        // Sum up the calories burned from each exercise
        for (ExerciseModel exerciseModel : exercises) {
            totalCaloriesBurnedFromExercise += exerciseModel.getCaloriesBurned();
            count++;
        }

        // Calculate the average calories burned
        double avg = totalCaloriesBurnedFromExercise / count;

        // Assign activity level based on average calories burned
        if (avg >= 200 && avg <= 299) {
            return 1.2;
        } else if (avg >= 300 && avg <= 399) {
            return 1.375;
        } else if (avg >= 400 && avg <= 499) {
            return 1.375;
        } else if (avg >= 500 && avg <= 699) {
            return 1.725;
        } else if (avg >= 700) {
            return 1.9;
        } else {
            return 1;
        }
    }

    // Calculate daily calorie needs using BMR and activity level
    public static double calculateDailyCalorieNeeds(double bmr, double activityLevel) {
        return bmr * activityLevel;
    }

}
