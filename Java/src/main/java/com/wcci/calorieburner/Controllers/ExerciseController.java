// package com.wcci.calorieburner.Controllers;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// import com.wcci.calorieburner.Models.ExerciseModel;
// import com.wcci.calorieburner.Services.ExerciseService;

// import jakarta.servlet.http.HttpServletRequest;

// import java.util.NoSuchElementException;

// @Controller
// @RequestMapping("/exercise")
// public class ExerciseController {

//     private final ExerciseService exerciseService;

//     public ExerciseController(ExerciseService exerciseService) {
//         this.exerciseService = exerciseService;
//     }

//     @PostMapping("/addexercise")
//     public String addExercise(
//         @RequestParam String name,
//         @RequestParam int caloriesBurned,
//         Model page
//     ) {
//         if(name.isBlank() || caloriesBurned == 0) {
//             page.addAttribute("invalidInfo", "Please enter correct information to add exercise, including numbers above 0");
//             return "errorAddExercise.html";
//         }
//         ExerciseModel exercise = new ExerciseModel(name, caloriesBurned);
//         exerciseService.saveExercise(exercise);
//         var exercises = exerciseService.findAll();
//         page.addAttribute("exercise", exercises);
//         return "index.html";
//     }


//     // Get a list of all users
//     @GetMapping({"", "/", "/home"})
//     public String home(Model page) {
//         var exercises = exerciseService.findAll();
//         page.addAttribute("exercises", exercises);
//         return "index.html";
//     }


//     @PostMapping("/delete")
//     public String deleteExercise(
//         @RequestParam Long deleteId,
//         Model page  
//     ) {
//         exerciseService.deleteExercise(deleteId);
//         var exercises = exerciseService.findAll();
//         page.addAttribute("exercises", exercises);
//         return "index.html";
//     }

    
//     @ExceptionHandler(NoSuchElementException.class)
//     public String errorOnDelete(HttpServletRequest request, Exception ex, Model page) {
//         String invalidId = request.getParameter("deleteId");
//         page.addAttribute("invalidId", invalidId);
//         return "errorExerciseID.html";
//     }

//     // @PostMapping("/home")
//     // public ExerciseModel createExercise(@RequestBody ExerciseModel exercise) {
//     //     return exerciseRepository.save(exercise);
//     // }

//     // @GetMapping("/all")
//     // public List<ExerciseModel> getAllExercises() {
//     //     return Streamable.of(exerciseRepository.findAll()).toList();
//     // }

//     // @GetMapping("/{id}")
//     // public ResponseEntity<ExerciseModel> getExerciseById(@PathVariable Long id) {
//     //     Optional<ExerciseModel> exercise = exerciseRepository.findById(id);
//     //     return exercise.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//     // }

//     // @PutMapping("/{id}")
//     // public ResponseEntity<ExerciseModel> updateExercise(@PathVariable Long id, @RequestBody ExerciseModel updatedExercise) {
//     //     if (!exerciseRepository.existsById(id)) {
//     //         return ResponseEntity.notFound().build();
//     //     }
//     //     updatedExercise.setId(id);
//     //     exerciseRepository.save(updatedExercise);
//     //     return ResponseEntity.ok(updatedExercise);
//     // }

//     // @DeleteMapping("/{id}")
//     // public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
//     //     if (!exerciseRepository.existsById(id)) {
//     //         return ResponseEntity.notFound().build();
//     //     }
//     //     exerciseRepository.deleteById(id);
//     //     return ResponseEntity.noContent().build();
//     // }
// }