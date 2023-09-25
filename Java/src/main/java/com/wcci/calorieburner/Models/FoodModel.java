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

}