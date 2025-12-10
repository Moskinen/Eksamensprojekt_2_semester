package com.example.eksamensprojekt_2_semester.service;

import com.example.eksamensprojekt_2_semester.model.VehicleReport;
import com.example.eksamensprojekt_2_semester.repository.VehicleReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleReportService {

    VehicleReportRepository vehicleReportRepository;

    @Autowired
    VehicleReportService(VehicleReportRepository vehicleReportRepository) {
        this.vehicleReportRepository = vehicleReportRepository;
    }

    public int createNewVehicleReport() {
        return vehicleReportRepository.createNewVehicleReport();
    }

    public List<VehicleReport> getAllVehicleReports() {
        return vehicleReportRepository.getAllVehicleReports();

    }

    public void calculateTotalCost(int vehicleReportId) {
        vehicleReportRepository.calculateTotalCost(vehicleReportId);
    }

}
