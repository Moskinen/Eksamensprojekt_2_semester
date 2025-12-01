package com.example.eksamensprojekt_2_semester.repository.impl;

import com.example.eksamensprojekt_2_semester.model.VehicleReport;
import com.example.eksamensprojekt_2_semester.repository.VehicleReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleReportRepositoryImpl implements VehicleReportRepository {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<VehicleReport> getAllVehicleReports() {
        String sql = "SELECT * FROM vehicle_report";
        RowMapper<VehicleReport> rowMapper = new BeanPropertyRowMapper<>(VehicleReport.class);
        return template.query(sql, rowMapper);
    }

}
