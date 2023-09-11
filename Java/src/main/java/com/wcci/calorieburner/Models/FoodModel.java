package com.wcci.calorieburner.Models;

import org.springframework.lang.NonNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Foods")
public class FoodModel {
    
    @Id @GeneratedValue private Long id;
    
    @NonNull
    @Column(unique = true)
    private String foodName;

    @NonNull
    private String imageurl;

    public FoodModel() {
    }

    

    public FoodModel(String foodName, String imageurl, UserModel user) {
        this.foodName = foodName;
        this.imageurl = imageurl;
        this.user = user;
    }



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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
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
        FoodModel other = (FoodModel) obj;
        if (foodName == null) {
            if (other.foodName != null)
                return false;
        } else if (!foodName.equals(other.foodName))
            return false;
        return true;
    }

    

}
