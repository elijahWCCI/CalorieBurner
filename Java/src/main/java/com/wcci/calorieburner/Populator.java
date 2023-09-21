package com.wcci.calorieburner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Models.FoodModel;
//import com.wcci.calorieburner.Models.UserModel;
import com.wcci.calorieburner.Repositories.ExerciseRepository;
import com.wcci.calorieburner.Repositories.FoodRepository;
import com.wcci.calorieburner.Repositories.UserRepository;

import jakarta.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {


    @Resource
    private FoodRepository fRepository;

    @Resource
    private ExerciseRepository eRepository;

    public Populator( FoodRepository fRepository, ExerciseRepository eRepository) {
        
        this.fRepository = fRepository;
        this.eRepository = eRepository;
    }

    @Override
    public void run(String... args) throws Exception {



        FoodModel food1 = new FoodModel("Whole Wheat Bread 1 Slice", 69, null );
        fRepository.save(food1);
        FoodModel food2 = new FoodModel("Brown Rice 1 Cup", 216, null );
        fRepository.save(food2);
        FoodModel food3 = new FoodModel("Oatmeal 1/2 Cup", 150, null );
        fRepository.save(food3);
        FoodModel food4 = new FoodModel("Quinoa 1/2 Cup", 111, null );
        fRepository.save(food4);
        FoodModel food5 = new FoodModel("Barley 1/2 Cup", 96, null );
        fRepository.save(food5);
        FoodModel food6 = new FoodModel("Whole Grain Cereal 1 Cup", 150, null );
        fRepository.save(food6);


        FoodModel food7 = new FoodModel("Spinach 1 Cup", 7, null );
        fRepository.save(food7);
        FoodModel food8 = new FoodModel("Carrots 1 Cup", 52, null );
        fRepository.save(food8);
        FoodModel food9 = new FoodModel("Bell Peppers 1 Cup", 30, null );
        fRepository.save(food9);
        FoodModel food10 = new FoodModel("Tomatoes 1 Cup", 18, null );
        fRepository.save(food10);
        FoodModel food11 = new FoodModel("Cauliflower 1 Cup", 25, null );
        fRepository.save(food11);
        FoodModel food12 = new FoodModel("Zucchini 1 Cup", 20, null );
        fRepository.save(food12);

        FoodModel food13 = new FoodModel("Banana", 105, null );
        fRepository.save(food13);
        FoodModel food14 = new FoodModel("Orange", 62, null );
        fRepository.save(food14);
        FoodModel food15 = new FoodModel("Strawberries 1 cup", 32, null );
        fRepository.save(food15);
        FoodModel food16 = new FoodModel("Blueberries 1 cup", 84, null );
        fRepository.save(food16);
        FoodModel food17 = new FoodModel("Grapes 1 cup", 69, null );
        fRepository.save(food17);
        FoodModel food18 = new FoodModel("Apple", 65, null );
        fRepository.save(food18);

        FoodModel food19 = new FoodModel("Greek Yogurt (Low-Fat) 6oz", 100, null );
        fRepository.save(food19);
        FoodModel food20 = new FoodModel("Cottage Cheese (Low-Fat) 1 cup", 206, null );
        fRepository.save(food20);
        FoodModel food21 = new FoodModel("Almond Milk (Unsweetened) 1 cup", 13, null );
        fRepository.save(food21);
        FoodModel food22 = new FoodModel("Cheese (Low-Fat) 1oz",60, null );
        fRepository.save(food22);
        FoodModel food23 = new FoodModel("Soy Milk (Unsweetened) 1 Cup", 80, null );
        fRepository.save(food23);
        FoodModel food24 = new FoodModel("Whole Milk 8oz", 150, null );
        fRepository.save(food24);

        FoodModel food25 = new FoodModel("Salmon 3.5oz", 206, null );
        fRepository.save(food25);
        FoodModel food26 = new FoodModel("Tofu 3.5oz", 144, null );
        fRepository.save(food26);
        FoodModel food27 = new FoodModel("Chicken Breast 3.5oz", 165, null );
        fRepository.save(food27);
        FoodModel food28 = new FoodModel("Beans (Black Beans) 1 Cup",277, null );
        fRepository.save(food28);
        FoodModel food29 = new FoodModel("Egg", 68, null );
        fRepository.save(food29);
        FoodModel food30 = new FoodModel("Lean Beef (Sirloin) 3.5oz", 143, null );
        fRepository.save(food30);

        ExerciseModel exercise1 = new ExerciseModel("Running (6 mph)",590);
        eRepository.save(exercise1);
        ExerciseModel exercise2 = new ExerciseModel("Cycling (12 mph)",680);
        eRepository.save(exercise2);
        ExerciseModel exercise3 = new ExerciseModel("Swimming (freestyle)",704);
        eRepository.save(exercise3);
        ExerciseModel exercise4 = new ExerciseModel("Jumping Rope",704);
        eRepository.save(exercise4);
        ExerciseModel exercise5 = new ExerciseModel("Rowing (moderate intensity)",493);
        eRepository.save(exercise5);
        ExerciseModel exercise6 = new ExerciseModel("Aerobics (high impact)",495);
        eRepository.save(exercise6);
        ExerciseModel exercise7 = new ExerciseModel("Hiking",354);
        eRepository.save(exercise7);
        ExerciseModel exercise8 = new ExerciseModel("Rock Climbing",704);
        eRepository.save(exercise8);
        ExerciseModel exercise9 = new ExerciseModel("Elliptical Trainer",670);
        eRepository.save(exercise9);
        ExerciseModel exercise10 = new ExerciseModel("Dancing (high intensity)",493);
        eRepository.save(exercise10);
        ExerciseModel exercise11 = new ExerciseModel("Boxing (sparring)",704);
        eRepository.save(exercise11);
        ExerciseModel exercise12 = new ExerciseModel("Kickboxing",701);
        eRepository.save(exercise12);
        ExerciseModel exercise13 = new ExerciseModel("Pilates",295);
        eRepository.save(exercise13);
        ExerciseModel exercise14 = new ExerciseModel("Yoga",290);
        eRepository.save(exercise14);
        ExerciseModel exercise15 = new ExerciseModel("Martial Arts",620);
        eRepository.save(exercise15);
        ExerciseModel exercise16 = new ExerciseModel("Calisthenics (moderate intensity)",325);
        eRepository.save(exercise16);
        ExerciseModel exercise17 = new ExerciseModel("Skiing (downhill)",420);
        eRepository.save(exercise17);
        ExerciseModel exercise18 = new ExerciseModel("Surfing",236);
        eRepository.save(exercise18);
        ExerciseModel exercise19 = new ExerciseModel("Paddleboarding",344);
        eRepository.save(exercise19);
        ExerciseModel exercise20 = new ExerciseModel("CrossFit",704);
        eRepository.save(exercise20);
        ExerciseModel exercise21 = new ExerciseModel("Tennis",590);
        eRepository.save(exercise21);
        ExerciseModel exercise22 = new ExerciseModel("Basketball",597);
        eRepository.save(exercise22);
        ExerciseModel exercise23 = new ExerciseModel("Soccers",498);
        eRepository.save(exercise23);
        ExerciseModel exercise24 = new ExerciseModel("Gardening",295);
        eRepository.save(exercise24);
        ExerciseModel exercise25 = new ExerciseModel("Jumping Jacks",493);
        eRepository.save(exercise25);
        ExerciseModel exercise26 = new ExerciseModel("Push-Ups",493);
        eRepository.save(exercise26);
        ExerciseModel exercise27 = new ExerciseModel("Squat Jumps",704);
        eRepository.save(exercise27);
        

    }

}
