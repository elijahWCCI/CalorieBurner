package com.wcci.calorieburner.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.calorieburner.Models.UserModel;

public interface UserRepository extends CrudRepository<UserModel,Long> {
    
}
