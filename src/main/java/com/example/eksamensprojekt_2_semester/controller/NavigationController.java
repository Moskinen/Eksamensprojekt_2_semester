package com.example.eksamensprojekt_2_semester.controller;

import com.example.eksamensprojekt_2_semester.model.Car;
import com.example.eksamensprojekt_2_semester.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NavigationController {

    @Autowired
    CarService carService;

    @GetMapping("/")
    public String listCars(Model model) {
        List<Car> cars = carService.getAllCars();
        List<Car> highlightedCars = carService.getHighlightedCars();
        model.addAttribute("cars", cars);
        model.addAttribute("highlightedCars", highlightedCars);
        return "home/index";
    }

    @GetMapping("/faq")
    public String faq(){
        return "home/faq";
    }
}
