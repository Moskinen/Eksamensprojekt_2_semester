package com.example.eksamensprojekt_2_semester.repository.impl;

import com.example.eksamensprojekt_2_semester.model.User;
import com.example.eksamensprojekt_2_semester.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {

    @Autowired
    JdbcTemplate template;

    public List<User> getAllCars() {

        String sql = "SELECT * FROM car";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return template.query(sql, rowMapper);

    }

    @Override
    public User updateCar(User car) {
        return null;
    }

    @Override
    public User deleteCar(int id) {
        return null;
    }

}
