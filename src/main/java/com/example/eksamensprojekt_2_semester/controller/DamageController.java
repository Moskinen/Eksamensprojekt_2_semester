package com.example.eksamensprojekt_2_semester.controller;

import com.example.eksamensprojekt_2_semester.model.Damage;
import com.example.eksamensprojekt_2_semester.model.VehicleReport;
import com.example.eksamensprojekt_2_semester.service.DamageService;
import com.example.eksamensprojekt_2_semester.service.VehicleReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class DamageController {

    DamageService damageService;
    VehicleReportService vehicleReportService;

    public DamageController(DamageService damageService) {
        this.damageService = damageService;
    }

    @GetMapping("/admin-update-vehicle-report")
    public String showDamages(@RequestParam ("id") int vehicleReportId, Model model) {

        List<Damage> damages = damageService.fetchDamageById(vehicleReportId);

        model.addAttribute("damages", damages);
        model.addAttribute("vehicleReportId", vehicleReportId);

        return "home/admin-update-vehicle-report";

    }

    @PostMapping("/admin-update-vehicle-report")
    public String updateVehicleReport(@RequestParam(required = false) List<String> name,
                                      @RequestParam(required = false) List<Integer> price,
                                      @RequestParam int vehicleReportId)
    {

        damageService.updateAllDamagesById(name, price, vehicleReportId);
        vehicleReportService.calculateTotalCost(vehicleReportId);

        return "redirect:/admin-active-rental-contracts";

    }

}
