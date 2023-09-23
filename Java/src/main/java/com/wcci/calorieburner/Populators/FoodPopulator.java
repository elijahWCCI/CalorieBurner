package com.wcci.calorieburner.Populators;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcci.calorieburner.Models.FoodModel;
import com.wcci.calorieburner.Repositories.FoodRepository;

import jakarta.annotation.Resource;

@Component
public class FoodPopulator implements CommandLineRunner {
        
    @Resource
    private FoodRepository fRepository;

    public FoodPopulator(FoodRepository fRepository) {
        this.fRepository = fRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        
        
        FoodModel food1 = new FoodModel("Whole Wheat Bread 1 Slice", 69, "https://kristineskitchenblog.com/wp-content/uploads/2014/08/whole-wheat-bread-1200-square-2678.jpg", "foodCategory1");
        fRepository.save(food1);
        FoodModel food2 = new FoodModel("Brown Rice 1 Cup", 216, null, "foodCategory1");
        fRepository.save(food2);
        FoodModel food3 = new FoodModel("Oatmeal 1/2 Cup", 150, null, "foodCategory1");
        fRepository.save(food3);
        FoodModel food4 = new FoodModel("Quinoa 1/2 Cup", 111, null, "foodCategory1");
        fRepository.save(food4);
        FoodModel food5 = new FoodModel("Barley 1/2 Cup", 96, null, "foodCategory1");
        fRepository.save(food5);
        FoodModel food6 = new FoodModel("Whole Grain Cereal 1 Cup", 150, null, "foodCategory1");
        fRepository.save(food6);


        FoodModel food7 = new FoodModel("Spinach 1 Cup", 7, null, "foodCategory2");
        fRepository.save(food7);
        FoodModel food8 = new FoodModel("Carrots 1 Cup", 52, null, "foodCategory2");
        fRepository.save(food8);
        FoodModel food9 = new FoodModel("Bell Peppers 1 Cup", 30, null, "foodCategory2");
        fRepository.save(food9);
        FoodModel food10 = new FoodModel("Tomatoes 1 Cup", 18, null, "foodCategory2");
        fRepository.save(food10);
        FoodModel food11 = new FoodModel("Cauliflower 1 Cup", 25, null, "foodCategory2");
        fRepository.save(food11);
        FoodModel food12 = new FoodModel("Zucchini 1 Cup", 20, null, "foodCategory2");
        fRepository.save(food12);

        FoodModel food13 = new FoodModel("Banana", 105, null, "foodCategory3");
        fRepository.save(food13);
        FoodModel food14 = new FoodModel("Orange", 62, null, "foodCategory3");
        fRepository.save(food14);
        FoodModel food15 = new FoodModel("Strawberries 1 cup", 32, null, "foodCategory3");
        fRepository.save(food15);
        FoodModel food16 = new FoodModel("Blueberries 1 cup", 84, null, "foodCategory3");
        fRepository.save(food16);
        FoodModel food17 = new FoodModel("Grapes 1 cup", 69, null, "foodCategory3");
        fRepository.save(food17);
        FoodModel food18 = new FoodModel("Apple", 65, null, "foodCategory3");
        fRepository.save(food18);

        FoodModel food19 = new FoodModel("Greek Yogurt (Low-Fat) 6oz", 100, null, "foodCategory4");
        fRepository.save(food19);
        FoodModel food20 = new FoodModel("Cottage Cheese (Low-Fat) 1 cup", 206, null, "foodCategory4");
        fRepository.save(food20);
        FoodModel food21 = new FoodModel("Almond Milk (Unsweetened) 1 cup", 13, null, "foodCategory4");
        fRepository.save(food21);
        FoodModel food22 = new FoodModel("Cheese (Low-Fat) 1oz",60, null, "foodCategory4");
        fRepository.save(food22);
        FoodModel food23 = new FoodModel("Soy Milk (Unsweetened) 1 Cup", 80, null, "foodCategory4");
        fRepository.save(food23);
        FoodModel food24 = new FoodModel("Whole Milk 8oz", 150, null, "foodCategory4");
        fRepository.save(food24);

        FoodModel food25 = new FoodModel("Salmon 3.5oz", 206, null, "foodCategory5");
        fRepository.save(food25);
        FoodModel food26 = new FoodModel("Tofu 3.5oz", 144, null, "foodCategory5");
        fRepository.save(food26);
        FoodModel food27 = new FoodModel("Chicken Breast 3.5oz", 165, null, "foodCategory5");
        fRepository.save(food27);
        FoodModel food28 = new FoodModel("Beans (Black Beans) 1 Cup",277, null, "foodCategory5");
        fRepository.save(food28);
        FoodModel food29 = new FoodModel("Egg", 68, null, "foodCategory5");
        fRepository.save(food29);
        FoodModel food30 = new FoodModel("Lean Beef (Sirloin) 3.5oz", 143, null, "foodCategory5");
        fRepository.save(food30);

    }
}
