package com.example.eksamensprojekt_2_semester.controller;

import com.example.eksamensprojekt_2_semester.model.Car;
import com.example.eksamensprojekt_2_semester.model.User;
import com.example.eksamensprojekt_2_semester.service.CarService;
import com.example.eksamensprojekt_2_semester.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    UserService userService;

    @Autowired
    CarService carService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/create-user")
    public String showCreateUserForm(@RequestParam int id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        model.addAttribute("user", new User());
        return "home/createUser";
    }

    @PostMapping("/create-user")
    public String createUser(@ModelAttribute User user, @RequestParam int id){
        userService.createUser(user);
        return "redirect:/create-user?id=" + id;
    }

}
