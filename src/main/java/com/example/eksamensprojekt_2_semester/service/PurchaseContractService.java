package com.example.eksamensprojekt_2_semester.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eksamensprojekt_2_semester.model.PurchaseContract;
import com.example.eksamensprojekt_2_semester.repository.PurchaseContractRepository;

@Service
public class PurchaseContractService {

	@Autowired
	PurchaseContractRepository purchaseContractRepository;

	public List<PurchaseContract> getPurchaseContracts() {
		return purchaseContractRepository.getPurchaseContracts();
	}

	public void createPurchaseContract(PurchaseContract purchaseContract) {
		purchaseContractRepository.createPurchaseContract(purchaseContract);
	}

	public PurchaseContract getPurchaseContractById(int id) {
		return purchaseContractRepository.getPurchaseContractById(id);
	}

	public boolean hasPurchaseContract(int id) {
		return purchaseContractRepository.hasPurchaseContract(id);
	}
}
