package com.example.eksamensprojekt_2_semester.repository;


import com.example.eksamensprojekt_2_semester.model.Damage;

import java.util.List;

public interface DamageRepository {

    List<Damage> fetchDamageById(int vehicleReport);

    int deleteDamageById(int vehicleReport);

    void createDamageById(Damage damage);

}
