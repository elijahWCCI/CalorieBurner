package com.wcci.calorieburner.Models;

public class DataForFormuladto {
    
    private int currentWeight;
    private int goalWeight;
    private int[] exercises;
    private int[] foods;
    private int currentHeight;
    private boolean gender;
    private String name;
    private String email;
    
    public DataForFormuladto(int currentWeight, int goalWeight, int[] exercises, int[] foods, int currentHeight,
            boolean gender, String name, String email) {
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.exercises = exercises;
        this.foods = foods;
        this.currentHeight = currentHeight;
        this.gender = gender;
        this.name = name;
        this.email = email;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getGoalWeight() {
        return goalWeight;
    }

    public int[] getExercises() {
        return exercises;
    }

    public int[] getFoods() {
        return foods;
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

    public String getEmail() {
        return email;
    }


    
    


}
