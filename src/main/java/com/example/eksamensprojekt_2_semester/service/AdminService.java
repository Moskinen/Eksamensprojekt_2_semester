package com.example.eksamensprojekt_2_semester.service;

import com.example.eksamensprojekt_2_semester.model.Admin;
import com.example.eksamensprojekt_2_semester.repository.impl.AdminRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepositoryImpl adminRepository;

    public Admin getAdmin(){
        return adminRepository.getAdmin();
    }


}
