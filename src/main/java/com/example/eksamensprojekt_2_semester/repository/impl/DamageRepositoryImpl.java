package com.example.eksamensprojekt_2_semester.repository.impl;

import com.example.eksamensprojekt_2_semester.model.Damage;
import com.example.eksamensprojekt_2_semester.repository.DamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DamageRepositoryImpl implements DamageRepository {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Damage> fetchDamageById(int vehicleReport) {
        String sql = "SELECT * FROM damages where vehicle_report_id = ?";
        RowMapper<Damage> rowMapper = new BeanPropertyRowMapper<>(Damage.class);
        return template.query(sql, rowMapper, vehicleReport);

    }

    @Override
    public int deleteDamageById(int vehicleReportId) {
        String sql = "DELETE FROM damages where vehicle_report_id = ?";
        return template.update(sql, vehicleReportId);
    }

    @Override
    public void createDamageById(Damage damage) {
        String sql = "INSERT INTO damages (name, price, vehicle_report_id) VALUES (?, ?, ?)";
        template.update(sql, damage.getName(), damage.getPrice(), damage.getVehicleReportId());

    }

}
