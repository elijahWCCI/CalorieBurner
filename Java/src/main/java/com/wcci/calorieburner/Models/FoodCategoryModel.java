package com.wcci.calorieburner.Models;

import java.util.Collection;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Food_Category")
public class FoodCategoryModel {
    
    @Id @GeneratedValue private Long id;

    @NonNull
    @Column(unique = true)
    private String categoryName;

    public FoodCategoryModel() {
    }

    public FoodCategoryModel(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "FoodCategoryModel [id=" + id + ", categoryName=" + categoryName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
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
        FoodCategoryModel other = (FoodCategoryModel) obj;
        if (categoryName == null) {
            if (other.categoryName != null)
                return false;
        } else if (!categoryName.equals(other.categoryName))
            return false;
        return true;
    }


    @OneToMany(mappedBy = "foodCategory")
    private Collection<FoodModel> food; 

    public Collection<FoodModel> getFood() {
        return food;
    }
}
