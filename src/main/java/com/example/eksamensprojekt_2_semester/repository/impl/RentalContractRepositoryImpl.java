package com.example.eksamensprojekt_2_semester.repository.impl;

import java.util.List;

import com.example.eksamensprojekt_2_semester.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.eksamensprojekt_2_semester.model.RentalContract;
import com.example.eksamensprojekt_2_semester.repository.RentalContractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RentalContractRepositoryImpl implements RentalContractRepository {
	@Autowired
	JdbcTemplate template;

    @Override
	public List<RentalContract> getRentalContracts() {
		String sql = "Select * FROM rental_contract";
		RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
		return template.query(sql, rowMapper);
	}

    @Override
	public void createRentalContract(RentalContract rentalContract) {
		String sql = "INSERT INTO rental_contract (from_date_time, to_date_time, max_km, unlimited, monthly_price, active, user_id, car_id, vehicle_report_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(sql, rentalContract.getFromDateTime(), rentalContract.getToDateTime(), rentalContract.getMaxKm(), rentalContract.isUnlimited(), rentalContract.getMonthlyPrice(), rentalContract.isActive(), rentalContract.getUserId(), rentalContract.getCarId(), rentalContract.getVehicleReportId());
	}

    @Override
	public RentalContract getRentalContractById(int id) {
		String sql = "SELECT * FROM rental_contract WHERE id=?";
		RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
		List<RentalContract> results = template.query(sql, rowMapper, id);
		return results.isEmpty() ? null : results.get(0);
	}

    @Override
	public boolean hasRentalContract(int id){
		return getRentalContractById(id) != null;
	}

    @Override
	//Method to return average rental period for rental contracts in days
	public int getAverageRentalPeriod(){
		String sql = "SELECT AVG(DATEDIFF(to_date_time, from_date_time)) as avg_contract_length_days FROM rental_contract";
		return template.queryForObject(sql, Integer.class);
	}

    @Override
	public List<RentalContract> getActiveRentalContracts() {
		String sql = "SELECT * FROM rental_contract WHERE active=true";
		RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
		return template.query(sql, rowMapper);
	}

    @Override
	public List<Car> getTodaysRentals () {
		String sql = "SELECT car.* FROM rental_contract JOIN car ON rental_contract.car_id = car.id WHERE rental_contract.to_date_time = CURDATE()";
		RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
		return template.query(sql, rowMapper);
	}

    @Override
	public List<Car> getTodaysReturns() {
		String sql = "SELECT car.* FROM rental_contract JOIN car ON rental_contract.car_id = car.id WHERE rental_contract.from_date_time = CURDATE()";
		RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
		return template.query(sql, rowMapper);
	}

    @Override
    public double getTotalSum(List<RentalContract> rentalContracts) {
        if (rentalContracts == null || rentalContracts.isEmpty()) {
            return 0.0;
        }

        double totalSum = 0.0;
        for (RentalContract contract : rentalContracts) {
            totalSum += contract.getMonthlyPrice();
        }
        return totalSum;
    }



}
