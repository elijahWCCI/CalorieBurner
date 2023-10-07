package com.wcci.calorieburner.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcci.calorieburner.Models.CalculateCaloriesDto;
import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Models.OtherExerciseDto;
import com.wcci.calorieburner.Models.OtherFoodDto;
import com.wcci.calorieburner.Models.SelectedExercise;
import com.wcci.calorieburner.Models.SelectedExerciseDto;
import com.wcci.calorieburner.Models.SelectedFood;
import com.wcci.calorieburner.Models.SelectedFoodDto;
import com.wcci.calorieburner.Models.User;
import com.wcci.calorieburner.Repositories.ExerciseRepository;
import com.wcci.calorieburner.Repositories.FoodRepository;
import com.wcci.calorieburner.Repositories.UserRepository;

@Service
public class CalculatorCaloriesService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    FoodRepository foodRepo;

    @Autowired
    ExerciseRepository exerciseRepo;

    // Calculate TDEE and compare it with total calories from food
    public boolean secretFormula(CalculateCaloriesDto dto) {
        // Save user details

        // Creating user object
        User userData = new User(dto.getName(), dto.isGender(), dto.getAge(), dto.getCurrentWeight(),
                dto.getCurrentHeight());

        // Adds foods/exercises selected from dropdown lists into database
        User user = saveSelectedFoodsAndExerciseToUser(dto.getUserFoodSelected(), dto.getUserSelectedExercise(),
                userData);

        // Adds foods/exercises manually entered into database
        //Added conditionals
        if (dto.getOtherFoodEntered() != null && dto.getOtherExerciseEntered() != null) {
            user = saveNewlyAddedFoods(dto.getOtherFoodEntered(), user);
            user = saveNewlyAddedExercise(dto.getOtherExerciseEntered(), user);
        } else if (dto.getOtherExerciseEntered() != null && dto.getOtherFoodEntered() == null) {
            user = saveNewlyAddedExercise(dto.getOtherExerciseEntered(), user);
        } else if (dto.getOtherExerciseEntered() == null && dto.getOtherFoodEntered() != null) {
            user = saveNewlyAddedFoods(dto.getOtherFoodEntered(), user);
        }

        

        // User object, selected foods, and selected exercises are now saved in DB.

        // Calculate calories burned vs calories consumed
        List<ExerciseModel> formExerciseModel = formExerciseModel(user.getSelectedExercises());
        // Calculate TDEE using BMR and activity level
        double tdee = calculateTDEE(dto.getCurrentWeight(), dto.getCurrentHeight(), dto.getAge(), dto.isGender(),
                formExerciseModel);
        System.out.println("========TDEE========>" + tdee);
        // Calculate total calories from food
        int totalCaloriesFromFood = calculateTotalCaloriesFromFood(user.getSelectedFoods());
        System.out.println("========totalCaloriesFromFood========>" + totalCaloriesFromFood);
        System.out.println("========Overall Result========>" + (tdee >= totalCaloriesFromFood));
        // Compare TDEE with total calories from food
        return tdee >= totalCaloriesFromFood;
    }

    // Calculate TDEE using BMR and activity level
    private static double calculateTDEE(double weightKg, double heightCm, int age, boolean gender,
            List<ExerciseModel> exercises) {
        // Calculate BMR based on weight, height, age, and gender
        double bmr = calculateBMR(weightKg, heightCm, age, gender);
        System.out.println("========BMR=======>" + bmr);
        // Calculate activity level based on exercises
        double activityLevel = calculateActivityLevel(exercises);
        System.out.println("========activityLevel=======>" + activityLevel);
        // Calculate TDEE using BMR and activity level
        return calculateDailyCalorieNeeds(bmr, activityLevel);
    }

    // Calculate total calories from food
    private static int calculateTotalCaloriesFromFood(List<SelectedFood> list) {
        int totalCaloriesFromFood = 0;

        // Sum up the calories from each food item
        for (SelectedFood foodModel : list) {
            totalCaloriesFromFood += foodModel.getFoodId().getCalories() * foodModel.getQuantity();
        }

        return totalCaloriesFromFood;
    }

    // Calculate BMR based on weight, height, age, and gender
    private static double calculateBMR(double weightKg, double heightCm, int age, boolean gender) {
        if (gender) {
            // BMR calculation for males
            return 88.362 + (13.397 * 0.453592 * weightKg) + (4.799 * 30.48 * heightCm) - (5.677 * age);
        } else {
            // BMR calculation for females
            return 447.593 + (9.247 * 0.453592 * weightKg) + (3.098 * 30.48 * heightCm) - (4.330 * age);
        }
    }

    // Calculate activity level based on average calories burned from exercises
    private static double calculateActivityLevel(List<ExerciseModel> exercises) {
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

    // Using stream API to transform list of objects into list of Long exercise IDs
    // Using map to extract exerciseId's from SelectedExerciseDTO
    private List<ExerciseModel> formExerciseModel(List<SelectedExercise> selectedExercises) {
        List<ExerciseModel> exerciseIds = selectedExercises.stream().map(SelectedExercise::getExerciseId)
                .collect(Collectors.toList());
        return exerciseIds;
    }

    private User saveNewlyAddedFoods(List<OtherFoodDto> dtoList, User user) {
        for (OtherFoodDto otherFood : dtoList) {
            FoodModel model = new FoodModel();
            model.setCalories(otherFood.getCalories());
            model.setFoodName(otherFood.getName());
            FoodModel foodModel = foodRepo.save(model);
            SelectedFood each = new SelectedFood();
            each.setFoodId(foodModel);
            each.setUser(user);
            each.setQuantity(1);
            List<SelectedFood> selectedFoods = user.getSelectedFoods();
            selectedFoods.add(each);
            user.setSelectedFoods(selectedFoods);
        }

        System.out.println("Total foods selected:" + user.getSelectedFoods().size());
        return userRepo.save(user);

    }

            private User saveNewlyAddedExercise(List<OtherExerciseDto> exerciseList,
            User user) {

        for (OtherExerciseDto exerciseModel : exerciseList) {
            ExerciseModel model = new ExerciseModel();
            model.setCaloriesBurned(exerciseModel.getCaloriesBurned());
            model.setName(exerciseModel.getName());
            ExerciseModel exerciseModelFromDb = exerciseRepo.save(model);
            SelectedExercise each = new SelectedExercise();
            each.setExerciseId(exerciseModelFromDb);
            each.setUser(user);
            List<SelectedExercise> selectedExercises = user.getSelectedExercises();
            selectedExercises.add(each);
            user.setSelectedExercises(selectedExercises);
        }
        System.out.println("Total exercises selected:" + user.getSelectedExercises().size());
        return userRepo.save(user);
    }

    private User saveSelectedFoodsAndExerciseToUser(List<SelectedFoodDto> dtoList,
            List<SelectedExerciseDto> exerciseList, User user) {
        List<SelectedFood> foodModelList = new ArrayList<>();
        List<SelectedExercise> exerciseModelList = new ArrayList<>();
        for (SelectedFoodDto foodModel : dtoList) {
            Optional<FoodModel> findById = foodRepo.findById(foodModel.getFoodId());
            if (findById.isPresent()) {
                SelectedFood each = new SelectedFood();
                each.setFoodId(findById.get());
                each.setUser(user);
                each.setQuantity(foodModel.getQuantity());
                foodModelList.add(each);
            }
        }

        for (SelectedExerciseDto exerciseModel : exerciseList) {
            Optional<ExerciseModel> findById = exerciseRepo.findById(exerciseModel.getExerciseId());
            if (findById.isPresent()) {
                SelectedExercise each = new SelectedExercise();
                each.setExerciseId(findById.get());
                each.setUser(user);
                exerciseModelList.add(each);
            }
        }

        user.setSelectedFoods(foodModelList);
        user.setSelectedExercises(exerciseModelList);
        return userRepo.save(user);
    }
}