package com.wcci.calorieburner.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.calorieburner.Models.FoodModel;

public interface FoodRepository extends CrudRepository<FoodModel, Long> {
	FoodModel findByFoodName(String name);
}