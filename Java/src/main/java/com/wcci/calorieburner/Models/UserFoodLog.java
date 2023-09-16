package com.wcci.calorieburner.Models;

import org.springframework.lang.NonNull;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "User_Food_Log")
public class UserFoodLog {
    
    @Id @GeneratedValue private Long id;

    @NonNull
    @Column(unique = true)
    private String foodName;

    private int servings;

    public UserFoodLog() {
    }

    

    public UserFoodLog(String foodName, int servings, FoodModel food, UserModel user) {
        this.foodName = foodName;
        this.servings = servings;
        this.food = food;
        this.user = user;
    }



    @ManyToOne 
    private FoodModel food;

    @ManyToOne 
    private UserModel user;

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getFoodName() {
        return foodName;
    }



    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }



    public int getServings() {
        return servings;
    }



    public void setServings(int servings) {
        this.servings = servings;
    }



    public FoodModel getFood() {
        return food;
    }



    public void setFood(FoodModel food) {
        this.food = food;
    }



    public UserModel getUser() {
        return user;
    }



    public void setUser(UserModel user) {
        this.user = user;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserFoodLog other = (UserFoodLog) obj;
        if (foodName == null) {
            if (other.foodName != null)
                return false;
        } else if (!foodName.equals(other.foodName))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "UserFoodLog [id=" + id + ", foodName=" + foodName + ", servings=" + servings + ", food=" + food
                + ", user=" + user + "]";
    }



    


}
