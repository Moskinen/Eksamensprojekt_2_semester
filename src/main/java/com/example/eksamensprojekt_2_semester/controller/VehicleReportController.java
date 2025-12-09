package com.example.eksamensprojekt_2_semester.controller;

import com.example.eksamensprojekt_2_semester.service.VehicleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VehicleReportController {

    @Autowired
    VehicleReportService vehicleReportService;

    public VehicleReportController(VehicleReportService vehicleReportService) {
        this.vehicleReportService = vehicleReportService;
    }

}
