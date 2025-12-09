package com.example.eksamensprojekt_2_semester.repository;

import com.example.eksamensprojekt_2_semester.model.VehicleReport;

import java.util.List;

public interface VehicleReportRepository {

    void createNewVehicleReport(VehicleReport vehicleReport);

    List<VehicleReport> getAllVehicleReports();

}
