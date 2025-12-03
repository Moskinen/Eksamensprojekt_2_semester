package com.example.eksamensprojekt_2_semester.controller;

import com.example.eksamensprojekt_2_semester.model.Damage;
import com.example.eksamensprojekt_2_semester.model.VehicleReport;
import com.example.eksamensprojekt_2_semester.service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DamageController {

    @Autowired
    DamageService damageService;

    public DamageController(DamageService damageService) {
        this.damageService = damageService;
    }

    @GetMapping("/updateVehicleReport")
    public String showDamages(@RequestParam int vehicleReportId, Model model) {

        List<Damage> damages = damageService.fetchDamageById(vehicleReportId);
        model.addAttribute("damages", damages);
        model.addAttribute("vehicleReportId", vehicleReportId);
        return "home/updateVehicleReport";

    }

    @PostMapping("/updateVehicleReport")
    public String updateVehicleReport(@RequestParam(required = false) List<String> name,
                                      @RequestParam(required = false) List<Integer> price,
                                      @RequestParam int vehicleReportId) {

        List<Damage> damages = new ArrayList<>();

        if(name != null && !name.isEmpty()) {
            for (int i = 0; i < name.size(); i++) {
                Damage damage = new Damage();
                damage.setName(name.get(i));
                damage.setPrice(price.get(i));
                damage.setVehicleReportId(vehicleReportId);
                damages.add(damage);

            }

        }

        damageService.updateAllDamages(damages, vehicleReportId);

        return ("redirect:/admin_index");

    }

}
