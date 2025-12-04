package com.example.eksamensprojekt_2_semester.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.eksamensprojekt_2_semester.model.PurchaseContract;
import com.example.eksamensprojekt_2_semester.repository.PurchaseContractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseContractRepositoryImpl implements PurchaseContractRepository {
	@Autowired
	JdbcTemplate template;

	public List<PurchaseContract> getPurchaseContracts() {
		String sql = "Select * FROM purchase_contract";
		RowMapper<PurchaseContract> rowMapper = new BeanPropertyRowMapper<>(PurchaseContract.class);
		return template.query(sql, rowMapper);
	}

	public void createPurchaseContract(PurchaseContract purchaseContract) {
		String sql = "INSERT INTO purchase_contract (price, receive_date, user_id, car_id, vehicle_report_id) VALUES(?, ?, ?, ?, ?)";
		template.update(sql, purchaseContract.getPrice(), purchaseContract.getReceiveDate(), purchaseContract.getUserId(), purchaseContract.getCarId(), purchaseContract.getVehicleReportId());
	}

	public PurchaseContract getPurchaseContractById(int id) {
		String sql = "SELECT * FROM purchase_contract WHERE id=?";
		RowMapper<PurchaseContract> rowMapper = new BeanPropertyRowMapper<>(PurchaseContract.class);
		PurchaseContract purchaseContract = template.queryForObject(sql, rowMapper, id);
		return purchaseContract;
	}

	public boolean hasPurchaseContract(int id){
		return getPurchaseContractById(id) != null;
	}

}
