package com.wcci.calorieburner.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SelectedFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private FoodModel foodId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SelectedFood() {
    }

    public SelectedFood(FoodModel foodId, int quantity) {
        this.foodId = foodId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public FoodModel getFoodId() {
        return foodId;
    }

    public void setFoodId(FoodModel foodId) {
        this.foodId = foodId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}