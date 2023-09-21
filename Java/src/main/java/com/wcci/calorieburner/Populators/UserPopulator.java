package com.wcci.calorieburner.Populators;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcci.calorieburner.Models.UserModel;
import com.wcci.calorieburner.Repositories.UserRepository;

import jakarta.annotation.Resource;

@Component
public class UserPopulator implements CommandLineRunner {

    @Resource
    private UserRepository uRepository;


    Date d1 = new Date();



    public UserPopulator(UserRepository uRepository) {
        this.uRepository = uRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        UserModel user1 = new UserModel("Homer", 39, "Male", 177, 240, 220, d1);
        uRepository.save(user1);
        UserModel user2 = new UserModel("Marge", 36, "Female", 170, 150, 145, d1);
        uRepository.save(user2);
        UserModel user3 = new UserModel("Peter", 42, "Male", 183, 270, 250, d1);
        uRepository.save(user3);
        UserModel user4 = new UserModel("Lois", 40, "Female", 172, 115, 110, d1);
        uRepository.save(user4);
        UserModel user5 = new UserModel("Brian", 10, "Male", 139, 64, 60, d1);
        uRepository.save(user5);

    }

}
