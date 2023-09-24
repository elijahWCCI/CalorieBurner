// package com.wcci.calorieburner.Models;

// import org.springframework.lang.NonNull;
// import jakarta.persistence.*;
// import java.util.Collection;

// @Entity
// public class ExerciseModel {
    
//     @Id @GeneratedValue private Long id;

//     // @NonNull
//     @Column(unique = true)
//     private String name;

//     private int caloriesBurned;

//     public ExerciseModel() {
//     }

//     public ExerciseModel(String name,int caloriesBurned) {
//         this.name = name;
//         this.caloriesBurned = caloriesBurned;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

    

//     public int getCaloriesBurned() {
//         return caloriesBurned;
//     }

//     public void setCaloriesBurned(int caloriesBurned) {
//         this.caloriesBurned = caloriesBurned;
//     }

//     @Override
//     public int hashCode() {
//         final int prime = 31;
//         int result = 1;
//         result = prime * result + ((name == null) ? 0 : name.hashCode());
//         return result;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         ExerciseModel other = (ExerciseModel) obj;
//         if (name == null) {
//             if (other.name != null)
//                 return false;
//         } else if (!name.equals(other.name))
//             return false;
//         return true;
//     }

//     @Override
//     public String toString() {
//         return "ExerciseModel [id=" + id + ", name=" + name + ", caloriesBurned=" + caloriesBurned;
//     }

    


// }
