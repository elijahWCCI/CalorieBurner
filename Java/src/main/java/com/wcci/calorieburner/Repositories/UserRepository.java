package com.wcci.calorieburner.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.calorieburner.Models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}