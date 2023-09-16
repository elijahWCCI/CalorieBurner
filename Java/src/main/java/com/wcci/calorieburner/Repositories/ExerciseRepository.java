package com.wcci.calorieburner.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.calorieburner.Models.ExerciseModel;

public interface ExerciseRepository extends CrudRepository<ExerciseModel,Long> {
    
}
