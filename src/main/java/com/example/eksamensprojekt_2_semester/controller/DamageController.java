package com.example.eksamensprojekt_2_semester.controller;

import com.example.eksamensprojekt_2_semester.model.Damage;
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

    @GetMapping("/createDamage")
    public String createDamage(@RequestParam int vehicleReportId, Model model) {
        model.addAttribute("vehicleReportId", vehicleReportId);
        return "home/createVehicleReport";
    }

    @PostMapping("/createDamage")
    public String saveDamages(@RequestParam List<String> name,
                              @RequestParam List<Integer> price,
                              @RequestParam int vehicleReportId) {

        List<Damage> damages = new ArrayList<>();

        for(int i = 0; i < name.size(); i++) {
            Damage damage = new Damage();
            damage.setName(name.get(i));
            damage.setPrice(price.get(i));
            damage.setVehicleReportId(vehicleReportId);
            damages.add(damage);

        }

        damageService.saveAllDamages(damages, vehicleReportId);

        return ("redirect:/admin_index");

    }




}
