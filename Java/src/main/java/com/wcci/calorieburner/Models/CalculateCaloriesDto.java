package com.wcci.calorieburner.Models;

import java.util.HashMap;
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
    private HashMap<String, Integer> foodList;
    private HashMap<String, Integer> exerciseList;

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
        this.foodList = new HashMap<String, Integer>();
        this.exerciseList = new HashMap<String, Integer>();
    }

  /*    public CalculateCaloriesDto(Iterable<FoodModel> food, Iterable<ExerciseModel> exercise) {
        this.foodList = new HashMap<String, Integer>();
        this.exerciseList = new HashMap<String, Integer>();
    } */

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

    public HashMap<String, Integer> getFoodList() {
        return foodList;
    }

    public HashMap<String, Integer> getExerciseList() {
        return exerciseList;
    }

    public void addFood(Long id){
        for(FoodModel selected : food){
            if(selected.getId().equals(id)){
                foodList.put(selected.getId().toString(), selected.getCalories());
                return;
            }
        }
    }

    public void addExercise(Long id){
        for(ExerciseModel selected : exercise){
            if(selected.getId().equals(id)){
                foodList.put(selected.getId().toString(), selected.getCaloriesBurned());
                return;
            }
        }
    }

    

   
}