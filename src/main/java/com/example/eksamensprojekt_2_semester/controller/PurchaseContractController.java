package com.example.eksamensprojekt_2_semester.controller;

import com.example.eksamensprojekt_2_semester.model.*;
import com.example.eksamensprojekt_2_semester.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PurchaseContractController{

	@Autowired
	PurchaseContractService purchaseContractService;
	@Autowired
	CarService carService;
	@Autowired
	UserService userService;

	@GetMapping("/create-purchase-contract")
	public String showCreateForm(@RequestParam int id, @RequestParam int userId, Model model) {

		Car car = carService.getCarById(id);
		User user = userService.getUserById(userId);

		PurchaseContract purchaseContract = new PurchaseContract();

		purchaseContract.setCarId(id);
		purchaseContract.setUserId(userId);

		model.addAttribute("purchase_contract", purchaseContract);
		model.addAttribute("car", car);
		model.addAttribute("user", user);

		return "home/create-purchase-contract";
	}

	@PostMapping("/create-purchase-contract")
	public String createRentalContract(@ModelAttribute PurchaseContract purchaseContract) {
		purchaseContractService.createPurchaseContract(purchaseContract);
		return "redirect:/";

	}

	@GetMapping("/admin-purchase-contracts")
	public String allPurchaseContracts(Model model){
		List<PurchaseContract> purchaseContracts = purchaseContractService.getPurchaseContracts();
		model.addAttribute("purchaseContracts", purchaseContracts);
		return "home/admin-purchase-contracts";
	}

}
