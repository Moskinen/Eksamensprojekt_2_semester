package com.example.eksamensprojekt_2_semester.controller;

import com.example.eksamensprojekt_2_semester.model.VehicleReport;
import com.example.eksamensprojekt_2_semester.service.VehicleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VehicleReportController {

    @Autowired
    VehicleReportService vehicleReportService;

    public VehicleReportController(VehicleReportService vehicleReportService) {
        this.vehicleReportService = vehicleReportService;
    }

    @GetMapping("/vehicleReports")
    public String showVehicleReports(Model model) {

        List<VehicleReport> vehicleReports = vehicleReportService.getAllVehicleReports();
        model.addAttribute("vehicleReports", vehicleReports);
        return "home/vehicleReports";

    }

}
