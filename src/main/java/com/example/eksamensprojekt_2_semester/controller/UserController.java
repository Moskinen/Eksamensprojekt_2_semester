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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String showCreateUserForm(@RequestParam int id, @RequestParam String mode, Model model) {

        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        model.addAttribute("user", new User());
        model.addAttribute("mode", mode);
        return "home/create-user";

    }

    @PostMapping("/create-user")
    public String createUser(@ModelAttribute User user, @RequestParam int id, @RequestParam String mode, RedirectAttributes redirectAttributes) {

        User savedUser = userService.createUser(user);
        redirectAttributes.addAttribute("id", id);
        redirectAttributes.addAttribute("userId", savedUser.getId());

        if (mode.equals("rent")) {

            return "redirect:/create-rental-contract";
        } else {

            return "redirect:/create-purchase-contract";

        }

    }

}
