package com.wcci.calorieburner.Services;

import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Repositories.ExerciseRepository;

public class ExerciseService {
        
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
           

        public void deleteExercise(Long id) {
            exerciseRepository.findById(id).get();
            exerciseRepository.deleteById(id);
           }
}
