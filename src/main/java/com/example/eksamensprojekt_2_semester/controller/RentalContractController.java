package com.example.eksamensprojekt_2_semester.controller;

import java.util.List;

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
	CarService carService;

	@Autowired
	UserService userService;

	@GetMapping("/create-rental-contract")
	public String showCreateForm(@RequestParam int carId, @RequestParam int userId, Model model) {
		Car car = carService.getCarById(carId);
		User user = userService.getUserById(userId);

		RentalContract rentalContract = new RentalContract();

		rentalContract.setCarId(carId);
		rentalContract.setUserId(userId);

		model.addAttribute("rental_contract", rentalContract); 
		model.addAttribute("car", car);
		model.addAttribute("user", user);
		return "home/create-rental-contract";
	}

	@PostMapping("/create-rental-contract")
	public String createCar(@ModelAttribute RentalContract rentalContract, RedirectAttributes redirectAttributes) {
		rentalContractService.createRentalContract(rentalContract);
		redirectAttributes.addFlashAttribute("message", "Rental Contract created successfully!");
		return "redirect:/create-rental-contract";
	}

	@GetMapping("/admin-active-rental-contracts")
	public String showActiveRentalContracts(Model model) {
		List<RentalContract> activeRentalContracts = rentalContractService.getActiveRentalContracts();
        double totalSum = rentalContractService.getTotalSum(activeRentalContracts);
		model.addAttribute("activeRentalContracts",activeRentalContracts);
        model.addAttribute("totalSum", totalSum);
		return "home/admin-active-rental-contracts";
	}

}
