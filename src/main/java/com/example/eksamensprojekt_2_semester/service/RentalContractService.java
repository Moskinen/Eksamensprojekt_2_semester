package com.example.eksamensprojekt_2_semester.service;

import java.util.List;

import com.example.eksamensprojekt_2_semester.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eksamensprojekt_2_semester.model.RentalContract;
import com.example.eksamensprojekt_2_semester.repository.RentalContractRepository;

@Service
public class RentalContractService {

	@Autowired
	RentalContractRepository rentalContractRepository;

	public List<RentalContract> getRentalContracts() {
		return rentalContractRepository.getRentalContracts();
	}

	public void createRentalContract(RentalContract rentalContract) {
		rentalContractRepository.createRentalContract(rentalContract);
	}

	public RentalContract getRentalContractById(int id) {
		return rentalContractRepository.getRentalContractById(id);
	}

	public boolean hasRentalContract(int id){
		return getRentalContractById(id) != null;
	}

	public int getAverageRentalPeriod(){
		return rentalContractRepository.getAverageRentalPeriod();
		}

	public List<RentalContract> getActiveRentalContracts() {
		return rentalContractRepository.getActiveRentalContracts();
	}
	public List<Car> getTodaysRentals (){
		return rentalContractRepository.getTodaysRentals();
	}

	public List<Car> getTodaysReturns(){
		return rentalContractRepository.getTodaysReturns();
	}

    public double getTotalSum(List<RentalContract> rentalContracts) {
        return rentalContractRepository.getTotalSum(rentalContracts);
    }
}
