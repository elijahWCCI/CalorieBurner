package com.wcci.calorieburner.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Models.UserExerciseLog;

public interface UserExerciseLogRepository extends CrudRepository<UserExerciseLog,Long> {
    
}
