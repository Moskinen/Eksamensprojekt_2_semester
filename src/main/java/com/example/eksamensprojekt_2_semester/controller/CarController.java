package com.example.eksamensprojekt_2_semester.controller;

import java.io.IOException;
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
	public String listCars(Model model, String availability) {
		List<Car> cars = carService.getCarByAvailabilityAndLocation(availability, "Alle");
		model.addAttribute("cars", cars);
		model.addAttribute("availability", availability);
		return "home/cars";
	}

	@GetMapping("/create-car")
	public String showCreateForm(Model model) {
		Car car = new Car();
		car.setHighlighted(false);
		model.addAttribute("car", car);
		return "home/admin-create-car";
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
		return "home/admin-update-car";
	}

	@PostMapping("/update-car")
	public String updateCar(@ModelAttribute Car car, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
		if (!imageFile.isEmpty()) {
			car.setImage(imageFile.getBytes());
		}
		carService.updateCar(car);
		return "redirect:/update-car";
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
		return "home/view-car";
	}

	@GetMapping("/cars/fragment")
	public String getCarsFragment(@RequestParam String location, @RequestParam String availability, Model model) {

		List<Car> cars = carService.getCarByAvailabilityAndLocation(availability, location);

		model.addAttribute("cars", cars);

		return "home/cars :: car-list";

	}

	@GetMapping("/admin-highlighted-cars")
	public String getHighlightedCars(Model model) {

		List<Car> highlightedCars = carService.getHighlightedCars();
		List<Car> cars = carService.getAllCars();
		model.addAttribute("highlightedCars", highlightedCars);
		model.addAttribute("cars", cars);

		return "home/admin-highlighted-cars";

	}

	@PostMapping("/admin-pick-highlighted-cars")
	public String updateHighlightedCars(@RequestParam int oldCarId, @RequestParam int newCarId) {

		carService.updateHighlightedCars(oldCarId, newCarId);

		return "redirect:/admin-highlighted-cars";

	}

}
