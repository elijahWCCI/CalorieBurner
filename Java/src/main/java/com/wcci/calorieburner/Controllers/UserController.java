package com.wcci.calorieburner.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wcci.calorieburner.Models.UserModel;
import com.wcci.calorieburner.Services.UserService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.NoSuchElementException;


@Controller
@ResponseBody
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // Create a new user
    @PostMapping("/home")
    public String addUser(
        @RequestParam String name,
        @RequestParam String gender,
        @RequestParam int age,
        @RequestParam int height,
        @RequestParam int weight,
        @RequestParam int targetWeight,
        @RequestParam Date desiredWeightDate,
        Model page
    ) {
        if(name.isBlank() || gender.isBlank() || height == 0 || weight == 0 || targetWeight == 0 || desiredWeightDate.equals(null)) {
            page.addAttribute("invalidInfo", "Please enter correct information to add user, including numbers above 0");
            return "errorAddUser.html";
        }
        UserModel user = new UserModel(name, age, gender, height, weight, targetWeight, desiredWeightDate);
        userService.saveUser(user);
        var users = userService.findAll();
        page.addAttribute("user", users);
        return "index.html";
    }


    // Get a list of all users
    @GetMapping({"", "/", "/home"})
    public String home(Model page) {
        var users = userService.findAll();
        page.addAttribute("users", users);
        return "index.html";
    }


    @PostMapping("/delete")
    public String deleteUser(
        @RequestParam Long deleteId,
        Model page  
    ) {
        userService.deleteUser(deleteId);
        var users = userService.findAll();
        page.addAttribute("users", users);
        return "index.html";
    }

    
    @ExceptionHandler(NoSuchElementException.class)
    public String errorOnDelete(HttpServletRequest request, Exception ex, Model page) {
        String invalidId = request.getParameter("deleteId");
        page.addAttribute("invalidId", invalidId);
        return "errorUserID.html";
    }

    // // Get a user by ID
    // @GetMapping("/{id}")
    // public ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
    //     Optional<UserModel> user = userRepository.findById(id);
    //     return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // // Update a user by ID
    // @PutMapping("/{id}")
    // public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel updatedUser) {
    //     if (!userRepository.existsById(id)) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     updatedUser.setId(id);
    //     userRepository.save(updatedUser);
    //     return ResponseEntity.ok(updatedUser);
    // }

    // // Delete a user by ID
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    //     if (!userRepository.existsById(id)) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     userRepository.deleteById(id);
    //     return ResponseEntity.noContent().build();
    // }
}