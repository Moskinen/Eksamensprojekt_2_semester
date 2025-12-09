package com.example.eksamensprojekt_2_semester.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.eksamensprojekt_2_semester.service.PurchaseContractService;
import com.example.eksamensprojekt_2_semester.service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.eksamensprojekt_2_semester.model.Car;
import com.example.eksamensprojekt_2_semester.service.CarService;

@Controller
public class CarController {
	private final CarService carService;
	private final RentalContractService rentalContractService;
	private final PurchaseContractService purchaseContractService;

	@Autowired
	public CarController(CarService carService, RentalContractService rentalContractService, PurchaseContractService purchaseContractService) {
		this.carService = carService;
		this.rentalContractService = rentalContractService;
		this.purchaseContractService = purchaseContractService;
	}

	@GetMapping("/cars")
	public String listCars(Model model) {
		List<Car> cars = carService.getAllCars();
		model.addAttribute("cars", cars);
		return "home/showAllCars";
	}

	@GetMapping("/create-car")
	public String showCreateForm(Model model) {
		model.addAttribute("car", new Car());
		return "home/admin_car_create";
	}

	@PostMapping("/create-car")
	public String createCar(@ModelAttribute Car car, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
		if (!imageFile.isEmpty()) {
			car.setImage(imageFile.getBytes());
		}
		carService.createCar(car);
		return "redirect:/create-car";
	}

	@GetMapping("/update-car")
	public String showUpdateForm(@RequestParam int id, Model model) {
		Car car = carService.getCarById(id);
		model.addAttribute("car", car);
		return "home/admin_car_update";
	}

	@PostMapping("/update-car")
	public String updateCar(@ModelAttribute Car car, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
		if (!imageFile.isEmpty()) {
			car.setImage(imageFile.getBytes());
		}
		carService.updateCar(car);
		return "redirect:/allCarsAdmin";
	}

	@GetMapping("/show-specific-car")
	public String showSpecificCar(@RequestParam int id, Model model) {
		Car car = carService.getCarById(id);

		boolean isRented = rentalContractService.hasRentalContract(id);
		boolean isSold = purchaseContractService.hasPurchaseContract(id);
		boolean isDamaged = car.getDamageStatus();

		model.addAttribute("car", car);
		model.addAttribute("isRented", isRented);
		model.addAttribute("isSold", isSold);
		model.addAttribute("isDamaged", isDamaged);
		return "home/show_specific_car";
	}

	@GetMapping("/cars/fragment")
	public String getCarsFragment(@RequestParam String location, @RequestParam String availability, Model model) {

		List<Car> cars = new ArrayList<>();

		cars = carService.getCarByAvailabilityAndLocation(availability, location);

		model.addAttribute("cars", cars);

		return "home/showAllCars :: carList";

	}

}
