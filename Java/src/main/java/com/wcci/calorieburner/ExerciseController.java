package com.wcci.calorieburner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @PostMapping
    public Exercise createExercise(@RequestBody Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Long id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        return exercise.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody Exercise updatedExercise) {
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
