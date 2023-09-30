package com.wcci.calorieburner.Models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean gender;
    private int age;
    private int currentWeight;
    private int targetWeight;
    private int currentHeight;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SelectedFood> selectedFoods = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SelectedExercise> selectedExercises = new ArrayList<>();

}