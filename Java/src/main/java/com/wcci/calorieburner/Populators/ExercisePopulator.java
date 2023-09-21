package com.wcci.calorieburner.Populators;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcci.calorieburner.Models.ExerciseModel;
import com.wcci.calorieburner.Repositories.ExerciseRepository;

import jakarta.annotation.Resource;

@Component
public class ExercisePopulator  implements CommandLineRunner  {

    @Resource
    private ExerciseRepository eRepository;

        public ExercisePopulator(ExerciseRepository eRepository) {
        this.eRepository = eRepository;
    }
    

    @Override
    public void run(String... args) throws Exception {

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
