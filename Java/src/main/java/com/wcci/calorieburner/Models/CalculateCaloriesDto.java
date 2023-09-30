package com.wcci.calorieburner.Models;

import java.util.ArrayList;
import java.util.List;

public class CalculateCaloriesDto {
    private int currentWeight;
    private int age;
    private double currentHeight;
    private boolean gender;
    private String name;
    private List<SelectedFoodDto> userFoodSelected;
    private List<SelectedExerciseDto> userSelectedExercise;

    private List<SelectedFood> selectedFoods = new ArrayList<>();
    private List<SelectedExercise> selectedExercises = new ArrayList<>();

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

}
