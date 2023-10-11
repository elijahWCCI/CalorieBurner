package com.wcci.calorieburner.Models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wcci.calorieburner.Services.ExerciseService;
import com.wcci.calorieburner.Services.FoodService;

public class CalculateCaloriesDto {

    private int currentWeight;
    private int age;
    private double currentHeight;
    private boolean gender;
    private String name;
    private String userName;
    private String password;

    private List<OtherFoodDto> otherFoodEntered;
    private List<OtherExerciseDto> otherExerciseEntered;

    private List<SelectedFoodDto> userFoodSelected; // Stored in DTO
    private List<SelectedExerciseDto> userSelectedExercise; // Stored in DTO

    private List<SelectedFood> selectedFoods = new ArrayList<>(); // Data from backend to frontend for dropdowns
    private List<SelectedExercise> selectedExercises = new ArrayList<>(); // Data from backend to frontend for dropdowns

    @Autowired
    private FoodService foodService;

    @Autowired
    private ExerciseService exerciseService;

    public CalculateCaloriesDto() {
    }

    public CalculateCaloriesDto(int currentWeight, int age, double currentHeight, boolean gender,
            String name, Iterable<FoodModel> foods, Iterable<ExerciseModel> exercises) {
        this.currentWeight = currentWeight;
        this.age = age;
        this.currentHeight = currentHeight;
        this.gender = gender;
        this.name = name;

        for (FoodModel food : foods) {
            selectedFoods.add(new SelectedFood(food, 0));
        }
        for (ExerciseModel exercise : exercises) {
            selectedExercises.add(new SelectedExercise(exercise, 0));
        }
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCurrentHeight() {
        return currentHeight;
    }

    public void setCurrentHeight(double currentHeight) {
        this.currentHeight = currentHeight;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SelectedFood> getSelectedFoods() {
        return selectedFoods;
    }

    public List<SelectedExercise> getSelectedExercises() {
        return selectedExercises;
    }

    public void addToSelectedFoods(FoodModel foodId, int quantity) {
        selectedFoods.add(new SelectedFood(foodId, quantity));
    }

    public void addToSelectedExercises(ExerciseModel exerciseId, int quantity) {
        selectedExercises.add(new SelectedExercise(exerciseId, quantity));
    }

    public List<SelectedFoodDto> getUserFoodSelected() {
        return userFoodSelected;
    }

    public void setUserFoodSelected(List<SelectedFoodDto> userFoodSelected) {
        this.userFoodSelected = userFoodSelected;
    }

    public List<SelectedExerciseDto> getUserSelectedExercise() {
        return userSelectedExercise;
    }

    public void setUserSelectedExercise(List<SelectedExerciseDto> userSelectedExercise) {
        this.userSelectedExercise = userSelectedExercise;
    }

    public List<OtherFoodDto> getOtherFoodEntered() {
        return otherFoodEntered;
    }

    public void setOtherFoodEntered(List<OtherFoodDto> otherFoodEntered) {
        this.otherFoodEntered = otherFoodEntered;
    }

    public List<OtherExerciseDto> getOtherExerciseEntered() {
        return otherExerciseEntered;
    }

    public void setOtherExerciseEntered(List<OtherExerciseDto> otherExerciseEntered) {
        this.otherExerciseEntered = otherExerciseEntered;
    }

    public void createUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void updateFoodList(Iterable<FoodModel> foods) {
        for (FoodModel food : foods) {
            selectedFoods.add(new SelectedFood(food, 0));
        }
    }

    public void updateExerciceList(Iterable<ExerciseModel> exercises) {
        for (ExerciseModel exercise : exercises) {
            selectedExercises.add(new SelectedExercise(exercise, 0));
        }
    }

}
