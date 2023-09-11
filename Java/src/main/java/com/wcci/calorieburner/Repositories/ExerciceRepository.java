package com.wcci.calorieburner.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.calorieburner.Models.ExerciceModel;

public interface ExerciceRepository extends CrudRepository<ExerciceModel,Long> {
    
}
