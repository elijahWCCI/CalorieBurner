package com.wcci.calorieburner.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Repositories.ExerciseRepository;
import com.wcci.calorieburner.Services.ExerciseService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.util.Streamable;

@Controller
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/home")
    public ExerciseModel createExercise(@RequestBody ExerciseModel exercise) {
        return exerciseRepository.save(exercise);
    }

    @GetMapping("/all")
    public List<ExerciseModel> getAllExercises() {
        return Streamable.of(exerciseRepository.findAll()).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseModel> getExerciseById(@PathVariable Long id) {
        Optional<ExerciseModel> exercise = exerciseRepository.findById(id);
        return exercise.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExerciseModel> updateExercise(@PathVariable Long id, @RequestBody ExerciseModel updatedExercise) {
        if (!exerciseRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedExercise.setId(id);
        exerciseRepository.save(updatedExercise);
        return ResponseEntity.ok(updatedExercise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        if (!exerciseRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        exerciseRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}