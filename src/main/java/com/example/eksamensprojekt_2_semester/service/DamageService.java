package com.example.eksamensprojekt_2_semester.service;

import com.example.eksamensprojekt_2_semester.model.Damage;
import com.example.eksamensprojekt_2_semester.repository.DamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageService {

    DamageRepository damageRepository;

    @Autowired
    public DamageService(DamageRepository damageRepository) {
        this.damageRepository = damageRepository;
    }

    public void createDamageById(Damage damage) {
        damageRepository.createDamageById(damage);
    }

    public void saveAllDamages(List<Damage> damages, int vehicleReportId) {

        for(Damage damage : damages) {

            damage.setVehicleReportId(vehicleReportId);
            damageRepository.createDamageById(damage);

        }

    }


}
