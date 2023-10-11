package com.wcci.calorieburner.Services;

import org.springframework.stereotype.Service;

import com.wcci.calorieburner.Models.CalculateCaloriesDto;
import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Models.User;
import com.wcci.calorieburner.Repositories.UserRepository;

import jakarta.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserRepository uRepository;

    public CalculateCaloriesDto findUserByCredentials(CalculateCaloriesDto userInfo, String username, String password) {
        
        for (User user : uRepository.findAll()) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                userInfo.setName(user.getName());
                userInfo.setAge(user.getAge());
                userInfo.setCurrentWeight(user.getCurrentWeight());
                userInfo.setCurrentHeight(user.getCurrentWeight());
                userInfo.setGender(user.isGender());
                userInfo.setUsername(username);
                userInfo.setPassword(password);
                return userInfo;
            }

        }
        return null;
    }
}
