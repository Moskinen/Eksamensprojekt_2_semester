package com.example.eksamensprojekt_2_semester.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.eksamensprojekt_2_semester.model.RentalContract;
import com.example.eksamensprojekt_2_semester.service.RentalContractService;

@Controller
public class RentalContractController {
	@Autowired
	RentalContractService rentalContractService;

	@GetMapping("/create-rental-contract")
	public String showCreateForm(Model model) {
		model.addAttribute("rental_contract", new RentalContract());
		return "home/rental_contract_create";
	}

	@PostMapping("/create-rental-contract")
	public String createCar(@ModelAttribute RentalContract rentalContract) {
		rentalContractService.createRentalContract(rentalContract);
		return "redirect:/create-rental-contract";
	}

	@GetMapping("/show-active-rental-contracts")
	public String showActiveRentalContracts(Model model) {
		List<RentalContract> activeRentalContracts = rentalContractService.getActiveRentalContracts();
        double totalSum = rentalContractService.getTotalSum(activeRentalContracts);
		model.addAttribute("activeRentalContracts",activeRentalContracts);
        model.addAttribute("totalSum", totalSum);
		return "home/active_rental_contracts";
	}

}
