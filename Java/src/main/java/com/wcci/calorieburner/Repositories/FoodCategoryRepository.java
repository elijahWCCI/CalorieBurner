package com.wcci.calorieburner.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.calorieburner.Models.FoodCategoryModel;
import com.wcci.calorieburner.Models.FoodModel;

public interface FoodCategoryRepository extends CrudRepository<FoodCategoryModel,Long> {


    
}
