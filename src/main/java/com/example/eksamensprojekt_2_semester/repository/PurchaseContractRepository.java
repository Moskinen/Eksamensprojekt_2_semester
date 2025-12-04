
package com.example.eksamensprojekt_2_semester.repository;

import java.util.List;

import com.example.eksamensprojekt_2_semester.model.PurchaseContract;

public interface PurchaseContractRepository {

	List<PurchaseContract> getPurchaseContracts();

	void createPurchaseContract(PurchaseContract purchaseContract);

	PurchaseContract getPurchaseContractById(int id);

	boolean hasPurchaseContract(int id);
}
