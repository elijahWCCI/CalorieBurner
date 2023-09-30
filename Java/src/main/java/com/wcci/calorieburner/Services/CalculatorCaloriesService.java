package com.wcci.calorieburner.Services;

import org.springframework.stereotype.Service;

import com.wcci.calorieburner.Models.CalculateCaloriesDto;

@Service
public class CalculatorCaloriesService {

    public boolean secretFormula(CalculateCaloriesDto calculateCaloriesDto) {
        if (calculateCaloriesDto.getName().contains("k")) {
            return false;
        }
        return true;
    }

}
