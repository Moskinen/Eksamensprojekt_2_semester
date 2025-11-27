package com.example.eksamensprojekt_2_semester.repository.impl;

import com.example.eksamensprojekt_2_semester.model.Car;
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

    public List<Car> getAllCars() {

        String sql = "SELECT * FROM car";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql, rowMapper);

    }

    @Override
    public Car updateCar(Car car) {
        return null;
    }

    @Override
    public Car deleteCar(int id) {
        return null;
    }

}
