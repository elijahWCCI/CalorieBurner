package com.wcci.calorieburner.Services;

import org.springframework.stereotype.Service;

import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Repositories.ExerciseRepository;

@Service
public class ExerciseService {
        
    private ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Iterable<ExerciseModel> getAll() {
        return exerciseRepository.findAll();
    }
}
