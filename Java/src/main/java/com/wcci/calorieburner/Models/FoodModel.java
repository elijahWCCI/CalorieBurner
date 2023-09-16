package com.wcci.calorieburner.Models;

import java.util.Collection;
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

    private int calories;

    @NonNull
    private String imageurl;

    public FoodModel() {
    }

    public FoodModel(String foodName,int calories, String imageurl,FoodCategoryModel foodCategory) {
        this.foodName = foodName;
        this.calories = calories;
        this.imageurl = imageurl;
        this.foodCategory = foodCategory;
    }

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

    

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFoodLog(Collection<UserFoodLog> foodLog) {
        this.foodLog = foodLog;
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

    

    @Override
    public String toString() {
        return "FoodModel [id=" + id + ", foodName=" + foodName + ", calories=" + calories + ", imageurl=" + imageurl
                + ", foodCategory=" + foodCategory + ", foodLog=" + foodLog + "]";
    }



    @ManyToOne
    private FoodCategoryModel foodCategory; 

    public FoodCategoryModel getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategoryModel foodCategory) {
        this.foodCategory = foodCategory;
    }

    @OneToMany(mappedBy = "food")
    private Collection<UserFoodLog> foodLog;

    public Collection<UserFoodLog> getFoodLog(){
        return foodLog;
    }


}
