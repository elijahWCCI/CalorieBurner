package com.wcci.calorieburner.Models;

public class DataForFormuladto {
    
    private int currentWeight;
    private int targetWeight;
    // private int[] exercises;
    // private int[] foods;
    private int height;
    private boolean gender;
    private String name;
    // private String email;

    
    public DataForFormuladto(int currentWeight, int targetWeight, int height,
            boolean gender, String name) {
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
        // this.exercises = exercises;
        // this.foods = foods;
        this.height = height;
        this.gender = gender;
        this.name = "Jose";
        // this.email = email;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getTargetWeight() {
        return targetWeight;
    }

    // public int[] getExercises() {
    //     return exercises;
    // }

    // public int[] getFoods() {
    //     return foods;
    // }

    public int getHeight() {
        return height;
    }

    public boolean isGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    // public String getEmail() {
    //     return email;
    // }

    // public void setCurrentWeight(int currentWeight) {
    //     this.currentWeight = currentWeight;
    // }

    // public void setGoalWeight(int goalWeight) {
    //     this.goalWeight = goalWeight;
    // }

    // public void setExercises(int[] exercises) {
    //     this.exercises = exercises;
    // }

    // public void setFoods(int[] foods) {
    //     this.foods = foods;
    // }

    // public void setCurrentHeight(int currentHeight) {
    //     this.currentHeight = currentHeight;
    // }

    // public void setGender(boolean gender) {
    //     this.gender = gender;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }


    
    


}
