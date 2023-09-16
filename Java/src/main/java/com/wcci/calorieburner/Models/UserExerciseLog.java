package com.wcci.calorieburner.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Use_Exercise_Log")
public class UserExerciseLog {
    
    @Id @GeneratedValue private Long id;

    public UserExerciseLog() {
    }

    

    public UserExerciseLog(ExerciseModel exercise, UserModel user) {
        this.exercise = exercise;
        this.user = user;
    }



    @ManyToOne
    private ExerciseModel exercise;
    
    @ManyToOne
    private UserModel user;

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }


    public ExerciseModel getExercise() {
        return exercise;
    }



    public void setExercise(ExerciseModel exercise) {
        this.exercise = exercise;
    }



    public UserModel getUser() {
        return user;
    }



    public void setUser(UserModel user) {
        this.user = user;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserExerciseLog other = (UserExerciseLog) obj;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "UserExerciseLog [id=" + id + ", exercise=" + exercise + ", user=" + user + "]";
    }

    

    
}
