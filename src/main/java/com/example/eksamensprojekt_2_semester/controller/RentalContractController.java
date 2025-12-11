package com.example.eksamensprojekt_2_semester.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.eksamensprojekt_2_semester.service.VehicleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.eksamensprojekt_2_semester.model.Car;
import com.example.eksamensprojekt_2_semester.model.RentalContract;
import com.example.eksamensprojekt_2_semester.model.User;
import com.example.eksamensprojekt_2_semester.service.CarService;
import com.example.eksamensprojekt_2_semester.service.RentalContractService;
import com.example.eksamensprojekt_2_semester.service.UserService;

@Controller
public class RentalContractController {
	@Autowired
	RentalContractService rentalContractService;
	@Autowired
	VehicleReportService vehicleReportService;
	@Autowired
	CarService carService;
	@Autowired
	UserService userService;

	@GetMapping("/create-rental-contract")
	public String showCreateForm(@RequestParam int id, @RequestParam int userId, Model model) {
		Car car = carService.getCarById(id);
		User user = userService.getUserById(userId);


		RentalContract rentalContract = new RentalContract();

		rentalContract.setCarId(id);
		rentalContract.setUserId(userId);
		rentalContract.setActive(true);

		model.addAttribute("rental_contract", rentalContract); 
		model.addAttribute("car", car);
		model.addAttribute("user", user);
		return "home/create-rental-contract";
	}

	@PostMapping("/create-rental-contract")
	public String createRentalContract(@ModelAttribute RentalContract rentalContract, RedirectAttributes redirectAttributes) {
		int vehicleReportId = vehicleReportService.createNewVehicleReport();
		rentalContractService.createRentalContract(rentalContract, vehicleReportId);
		redirectAttributes.addFlashAttribute("successMessage", "Rental contract created successfully!");
		return "redirect:/";

	}

	@GetMapping("/admin-active-rental-contracts")
	public String showActiveRentalContracts(Model model) {
	    List<RentalContract> activeRentalContracts = rentalContractService.getActiveRentalContracts();
	    double totalSum = rentalContractService.getTotalSum();

	    Map<Integer, Car> carsById = new HashMap<>();
	    for (Car car : carService.getAllCars()) {
	        if (car != null) {
	            carsById.put(car.getId(), car);
	        }
	    }

	    model.addAttribute("activeRentalContracts", activeRentalContracts);
	    model.addAttribute("totalSum", totalSum);
	    model.addAttribute("carsById", carsById);

	    return "home/admin-active-rental-contracts";
	}

}
