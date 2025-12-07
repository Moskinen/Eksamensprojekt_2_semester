package com.example.eksamensprojekt_2_semester.controller;

import com.example.eksamensprojekt_2_semester.model.Admin;
import com.example.eksamensprojekt_2_semester.model.Car;
import com.example.eksamensprojekt_2_semester.service.AdminService;
import com.example.eksamensprojekt_2_semester.service.CarService;
import com.example.eksamensprojekt_2_semester.service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    CarService carService;
    @Autowired
    private RentalContractService rentalContractService;

    @GetMapping("/login")
    public String login(){
        return "home/login";
    }

    //Handles login form submission if it fails the user is sent back to login
    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username,
                              @RequestParam String pwd) {
        Admin admin = adminService.getAdmin();

        if (admin.getUsername().equals(username) && admin.getPassword().equals(pwd)) {
            return "redirect:/admin_index";
        } else {
            return "home/login";
        }
    }

    @GetMapping ("/admin_index")
    public String admin_index(Model model){
        int totalCars = carService.getTotalCars();
        model.addAttribute("totalCars", totalCars);
        return "home/admin_index";
    }

    @GetMapping ("/allCarsAdmin")
    public String allCarsAdmin(Model model){
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "home/allCarsAdmin";
    }

    @GetMapping ("/rentals")
    public String todaysRentals(Model model){
        model.addAttribute("todaysRentals", rentalContractService.getTodaysRentals());
        model.addAttribute("todaysReturns", rentalContractService.getTodaysReturns());
        return ("home/todaysRentals");
    }



}
