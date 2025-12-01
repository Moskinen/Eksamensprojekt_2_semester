package com.example.eksamensprojekt_2_semester.repository.impl;

import com.example.eksamensprojekt_2_semester.model.Damage;
import com.example.eksamensprojekt_2_semester.repository.DamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DamageRepositoryImpl implements DamageRepository {

@Autowired
    JdbcTemplate template;

    @Override
    public void createDamageById(Damage damage) {
        String sql = "INSERT INTO damage (name, price, vehicle_report_id) VALUES (?, ?, ?)";
        template.update(sql, damage.getName(), damage.getPrice(), damage.getVehicleReportId());

    }
}
