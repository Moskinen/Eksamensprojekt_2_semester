package com.example.eksamensprojekt_2_semester.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.eksamensprojekt_2_semester.model.PurchaseContract;
import com.example.eksamensprojekt_2_semester.service.PurchaseContractService;

@Controller
public class PurchaseContractController{
	@Autowired
	PurchaseContractService purchaseContractService;

	@GetMapping("/create-purchase-contract")
	public String showCreateForm(Model model) {
		model.addAttribute("purchase_contract", new PurchaseContract());
		return "home/purchase_contract_create";
	}

	@PostMapping("/create-purchase-contract")
	public String createCar(@ModelAttribute PurchaseContract purchaseContract) {
		purchaseContractService.createPurchaseContract(purchaseContract);
		return "redirect:/create-purchase-contract";
	}

}
