package com.example.eksamensprojekt_2_semester.repository;


import com.example.eksamensprojekt_2_semester.model.Damage;

import java.util.List;

public interface DamageRepository {

    public List<Damage> fetchDamageById(int vehicleReport);

    public int deleteDamageById(int vehicleReport);

    public void createDamageById(Damage damage);

}
