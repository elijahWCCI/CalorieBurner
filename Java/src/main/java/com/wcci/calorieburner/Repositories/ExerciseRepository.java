package com.wcci.calorieburner.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wcci.calorieburner.Models.ExerciseModel;

public interface ExerciseRepository extends JpaRepository<ExerciseModel, Long> {

}