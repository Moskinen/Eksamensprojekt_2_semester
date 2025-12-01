package com.example.eksamensprojekt_2_semester.service;

import com.example.eksamensprojekt_2_semester.repository.VehicleReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleReportService {

    VehicleReportRepository vehicleReportRepository;

    @Autowired
    VehicleReportService(VehicleReportRepository vehicleReportRepository) {
        this.vehicleReportRepository = vehicleReportRepository;
    }

}
