package com.example.eksamensprojekt_2_semester.repository.impl;

import java.util.List;

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

	public List<RentalContract> getRentalContracts() {
		String sql = "Select * FROM rental_contract";
		RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
		return template.query(sql, rowMapper);
	}

	public void createRentalContract(RentalContract rentalContract) {
		String sql = "INSERT INTO rental_contract (from_date_time, to_date_time, max_km, unlimited, active, user_id, car_id, vehicle_report_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(sql, rentalContract.getFromDataTime(), rentalContract.getToDateTime(), rentalContract.getMaxKm(), rentalContract.isUnlimited(), rentalContract.isActive(), rentalContract.getUserId(), rentalContract.getCarId(), rentalContract.getVehicleReportId());
	}

	public RentalContract getRentalContractById(int id) {
		String sql = "SELECT * FROM rental_contract WHERE id=?";
		RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
		List<RentalContract> results = template.query(sql, rowMapper, id);
		return results.isEmpty() ? null : results.get(0);
	}

	public boolean hasRentalContract(int id){
		return getRentalContractById(id) != null;
	}

}
