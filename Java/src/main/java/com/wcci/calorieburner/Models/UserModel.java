package com.wcci.calorieburner.Models;


import org.springframework.lang.NonNull;
import java.util.Collection;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="Users")
public class UserModel {
    
    @Id @GeneratedValue private Long id;

    // @NonNull
    @Column(unique = true)
    private String name; 

    private int age;

    private String gender;

    private int height;

    private int weight;

    private int targetWeight;

    private Date desiredWeightDate;
    public UserModel() {
    }

    

    public UserModel(String name, int age, String gender, int height, int weight, int targetWeight,
            Date desiredWeightDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.targetWeight = targetWeight;
        this.desiredWeightDate = desiredWeightDate;
    }

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



    public int getAge() {
        return age;
    }



    public void setAge(int age) {
        this.age = age;
    }



    public String getGender() {
        return gender;
    }



    public void setGender(String gender) {
        this.gender = gender;
    }



    public int getHeight() {
        return height;
    }



    public void setHeight(int height) {
        this.height = height;
    }



    public int getWeight() {
        return weight;
    }



    public void setWeight(int weight) {
        this.weight = weight;
    }



    public int getTargetWeight() {
        return targetWeight;
    }



    public void setTargetWeight(int targetWeight) {
        this.targetWeight = targetWeight;
    }



    public Date getDesiredWeightDate() {
        return desiredWeightDate;
    }



    public void setDesiredWeightDate(Date desiredWeightDate) {
        this.desiredWeightDate = desiredWeightDate;
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
        UserModel other = (UserModel) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "UserModel [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", height=" + height
                + ", weight=" + weight + ", targetWeight=" + targetWeight + ", desiredWeightDate=" + desiredWeightDate
                + "]";
    }


    
    
    



    

    
}
