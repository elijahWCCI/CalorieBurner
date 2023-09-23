package com.wcci.calorieburner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
(scanBasePackages={
    "com.wcci.Controllers", "com.wcci.Models", "com.wcci.Populators", "com.wcci.Repositories", "com.wcci.Services",})
public class CalorieburnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalorieburnerApplication.class, args);
	}

}
