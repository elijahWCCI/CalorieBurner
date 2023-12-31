package com.wcci.calorieburner.Models;

import jakarta.persistence.*;

@Entity
public class ExerciseModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private int caloriesBurned;

    public ExerciseModel() {
    }

    public ExerciseModel(String name, int caloriesBurned) {
        this.name = name;
        this.caloriesBurned = caloriesBurned;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public String getExerciseId() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

}