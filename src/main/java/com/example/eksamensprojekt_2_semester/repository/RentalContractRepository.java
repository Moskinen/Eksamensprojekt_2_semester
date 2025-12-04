package com.example.eksamensprojekt_2_semester.repository;

import java.util.List;

import com.example.eksamensprojekt_2_semester.model.RentalContract;

public interface RentalContractRepository {

	List<RentalContract> getRentalContracts();

	void createRentalContract(RentalContract rentalContract);

	RentalContract getRentalContractById(int id);

	boolean hasRentalContract(int id);
}
