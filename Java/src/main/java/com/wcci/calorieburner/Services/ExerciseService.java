package com.wcci.calorieburner.Services;

import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Repositories.ExerciseRepository;

public class ExerciseService {
        
    private ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Iterable<ExerciseModel> getAll() {
        return exerciseRepository.findAll();
    }
}
