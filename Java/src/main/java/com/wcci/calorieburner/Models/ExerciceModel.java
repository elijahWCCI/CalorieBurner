package com.wcci.calorieburner.Models;

import org.springframework.lang.NonNull;
import jakarta.persistence.*;


@Entity
public class ExerciceModel {
    
    @Id @GeneratedValue private Long id;

    @NonNull
    @Column(unique = true)
    private String name;

    public ExerciceModel() {
    }

    public ExerciceModel(String name,UserModel user) {
        this.name = name;
        this.user = user;
    }

    @ManyToOne
    private UserModel user; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        ExerciceModel other = (ExerciceModel) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ExerciceModel [id=" + id + ", name=" + name + ", user=" + user + "]";
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

}
