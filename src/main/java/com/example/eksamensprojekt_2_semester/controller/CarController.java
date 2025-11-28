package com.example.eksamensprojekt_2_semester.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.eksamensprojekt_2_semester.model.Car;
import com.example.eksamensprojekt_2_semester.service.CarService;

@Controller
public class CarController {
	private final CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/create-car")
	public String showCreateForm(Model model) {
		model.addAttribute("car", new Car());
		return "admin_car_create";
	}

	@PostMapping("/create-car")
	public String createCar(@ModelAttribute Car car) {
		carService.createCar(car);
		return "redirect:/create-car";
	}

	@GetMapping("/update-car")
	public String showUpdateForm(@RequestParam int id, Model model) {
		Car car = carService.getCarById(id);
		model.addAttribute("car", car);
		return "admin_car_update";
	}

	@PostMapping("/update-car")
	public String updateCar(@ModelAttribute Car car) {
		carService.updateCar(car);
		return "redirect:/update-car";
	}
}
