package com.wcci.calorieburner.Models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private boolean gender;
    private int age;
    private int currentWeight;
    private double currentHeight;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SelectedFood> selectedFoods = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SelectedExercise> selectedExercises = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getCurrentHeight() {
        return currentHeight;
    }

    public void setCurrentHeight(double currentHeight) {
        this.currentHeight = currentHeight;
    }

    public List<SelectedFood> getSelectedFoods() {
        return selectedFoods;
    }

    public void setSelectedFoods(List<SelectedFood> selectedFoods) {
        this.selectedFoods = selectedFoods;
    }

    public List<SelectedExercise> getSelectedExercises() {
        return selectedExercises;
    }

    public void setSelectedExercises(List<SelectedExercise> selectedExercises) {
        this.selectedExercises = selectedExercises;
    }

    public User() {
        super();
    }

    public User(String name, boolean gender, int age, int currentWeight, double currentHeight) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.currentWeight = currentWeight;
        this.currentHeight = currentHeight;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    



}