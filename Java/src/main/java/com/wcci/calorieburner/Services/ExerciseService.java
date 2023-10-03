package com.wcci.calorieburner.Services;

import org.springframework.stereotype.Service;

import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Repositories.ExerciseRepository;

import jakarta.annotation.Resource;

@Service
public class ExerciseService {

    @Resource
    private ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public ExerciseModel saveExercise(ExerciseModel exerciseModel) {
        return exerciseRepository.save(exerciseModel);
    }

    public Iterable<ExerciseModel> findAll() {
        return exerciseRepository.findAll();
    }

    public ExerciseModel findExerciseById(Long id) {
        return exerciseRepository.findById(id).get();

    }

    public ExerciseModel getExerciseById(Long id) {
        return exerciseRepository.findById(id).get();
    }
}