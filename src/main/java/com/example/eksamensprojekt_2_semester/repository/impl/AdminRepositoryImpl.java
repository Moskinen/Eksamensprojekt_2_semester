package com.example.eksamensprojekt_2_semester.repository.impl;

import com.example.eksamensprojekt_2_semester.model.Admin;
import com.example.eksamensprojekt_2_semester.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    @Autowired
    JdbcTemplate template;

    @Override
    public Admin getAdmin() {
        String sql = "SELECT username, password FROM admin";
        RowMapper<Admin> adminRowMapper = new BeanPropertyRowMapper<>(Admin.class);
        return template.queryForObject(sql, adminRowMapper);
    }
}
