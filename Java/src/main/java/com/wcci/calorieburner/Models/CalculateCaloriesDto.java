package com.wcci.calorieburner.Models;

import java.util.List;

public class CalculateCaloriesDto {
    private int currentWeight;
    private int targetWeight;
    private int age;
    private int currentHeight;
    private boolean gender;
    private String name;
    private Iterable<FoodModel> food;
    private Iterable<ExerciseModel> exercise;

    public CalculateCaloriesDto(int currentWeight, int targetWeight, int age, int currentHeight, boolean gender,
            String name,Iterable<FoodModel> food, Iterable<ExerciseModel> exercise) {
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
        this.age = age;
        this.currentHeight = currentHeight;
        this.gender = gender;
        this.name = name;
        this.food = food;
        this.exercise = exercise;
    }

    public Iterable<ExerciseModel> getExercise(){
        return this.exercise;
    }

    public Iterable<FoodModel> getFood(){
        return this.food;
    }
    public int getCurrentWeight() {
        return currentWeight;
    }
    public int getTargetWeight() {
        return targetWeight;
    }
    public int getAge() {
        return age;
    }
    public int getCurrentHeight() {
        return currentHeight;
    }
    public boolean isGender() {
        return gender;
    }
    public String getName() {
        return name;
    }

    

}