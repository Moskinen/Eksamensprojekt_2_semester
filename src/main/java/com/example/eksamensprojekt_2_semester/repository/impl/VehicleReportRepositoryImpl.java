package com.example.eksamensprojekt_2_semester.repository.impl;

import com.example.eksamensprojekt_2_semester.model.VehicleReport;
import com.example.eksamensprojekt_2_semester.repository.VehicleReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class VehicleReportRepositoryImpl implements VehicleReportRepository {

    @Autowired
    JdbcTemplate template;

    @Override
    public int createNewVehicleReport() {

        String sql = "INSERT INTO vehicle_report(total_cost) VALUES (0)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(connection -> {

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            return ps;


        }, keyHolder );

        return keyHolder.getKey().intValue();

    }

    @Override
    public List<VehicleReport> getAllVehicleReports() {
        String sql = "SELECT * FROM vehicle_report";
        RowMapper<VehicleReport> rowMapper = new BeanPropertyRowMapper<>(VehicleReport.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public void calculateTotalCost(int vehicleReportId) {

        String sql = "UPDATE vehicle_report SET total_cost =  ( SELECT COALESCE(SUM(price), 0) FROM damages WHERE vehicle_report_id = ?) WHERE id = ?";
        template.update(sql, vehicleReportId, vehicleReportId);

    }

}
