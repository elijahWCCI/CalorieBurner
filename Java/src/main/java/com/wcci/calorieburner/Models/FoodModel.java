package com.wcci.calorieburner.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Foods")
public class FoodModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String foodName;

    private int calories;
    private String foodCategory;
    private String imageurl;

    public FoodModel() {
    }

    public FoodModel(String foodName, int calories, String foodCategory, String imageurl) {
        this.foodName = foodName;
        this.calories = calories;
        this.foodCategory = foodCategory;
        this.imageurl = imageurl;
    }

    public Long getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getCalories() {
        return calories;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

}