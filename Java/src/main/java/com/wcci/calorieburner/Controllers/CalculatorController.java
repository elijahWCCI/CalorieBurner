/* package com.wcci.calorieburner.Controllers;

import java.util.HashMap;
import java.util.Map;

public class CalculatorController {
    private static final double SEDENTARY_MULTIPLIER = 1.2;
    private static final double LIGHTLY_ACTIVE_MULTIPLIER = 1.375;
    private static final double MODERATELY_ACTIVE_MULTIPLIER = 1.55;
    private static final double VERY_ACTIVE_MULTIPLIER = 1.725;
    private static final double SUPER_ACTIVE_MULTIPLIER = 1.9;
    private static final Map<String, Double> EXERCISE_CALORIE_BURN_RATES = new HashMap<>();

    static {
        EXERCISE_CALORIE_BURN_RATES.put("Running", 600.0);
        EXERCISE_CALORIE_BURN_RATES.put("Cycling", 400.0);
        EXERCISE_CALORIE_BURN_RATES.put("Swimming", 500.0);
        EXERCISE_CALORIE_BURN_RATES.put("Jumping Rope", 700.0);
        EXERCISE_CALORIE_BURN_RATES.put("Rowing", 600.0);
        EXERCISE_CALORIE_BURN_RATES.put("Push-Ups", 350.0);
        EXERCISE_CALORIE_BURN_RATES.put("Pull-Ups", 400.0);
        EXERCISE_CALORIE_BURN_RATES.put("Sit-Ups", 250.0);
        EXERCISE_CALORIE_BURN_RATES.put("Chin-Ups", 400.0);
    }

    public static double calculateCaloriesBurned(String exerciseType, int numberOfExercises) {
        Double calorieBurnRate = EXERCISE_CALORIE_BURN_RATES.get(exerciseType);

        if (calorieBurnRate == null) {
            throw new IllegalArgumentException("Invalid exercise type");
        }

        double caloriesBurned = calorieBurnRate * (numberOfExercises / 60.0); // Assuming exercises are in minutes

        return caloriesBurned;
    }

    public static double calculateDailyCalories(UserData userData, ActivityLevel activityLevel) {
        double bmr;
        if ("male".equalsIgnoreCase(userData.getGender())) {
            bmr = 88.362 + (13.397 * userData.getCurrentWeight()) + (4.799 * userData.getHeight()) - (5.677 * userData.getAge());
        } else {
            bmr = 447.593 + (9.247 * userData.getCurrentWeight()) + (3.098 * userData.getHeight()) - (4.330 * userData.getAge());
        }


        double tdee;
        switch (activityLevel) {
            case SEDENTARY:
                tdee = bmr * SEDENTARY_MULTIPLIER;
                break;
            case LIGHTLY_ACTIVE:
                tdee = bmr * LIGHTLY_ACTIVE_MULTIPLIER;
                break;
            case MODERATELY_ACTIVE:
                tdee = bmr * MODERATELY_ACTIVE_MULTIPLIER;
                break;
            case VERY_ACTIVE:
                tdee = bmr * VERY_ACTIVE_MULTIPLIER;
                break;
            case SUPER_ACTIVE:
                tdee = bmr * SUPER_ACTIVE_MULTIPLIER;
                break;
            default:
                throw new IllegalArgumentException("Invalid activity level");
        }

        return tdee;
    }
}
 */