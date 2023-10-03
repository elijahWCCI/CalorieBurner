package com.wcci.calorieburner.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SelectedExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private ExerciseModel exerciseId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SelectedExercise() {
    }

    public SelectedExercise(ExerciseModel exerciseId, int quantity) {
        this.exerciseId = exerciseId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public ExerciseModel getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(ExerciseModel exerciseId) {
        this.exerciseId = exerciseId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
