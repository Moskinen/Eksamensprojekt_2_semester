package com.example.eksamensprojekt_2_semester.repository.impl;

import com.example.eksamensprojekt_2_semester.model.Car;
import com.example.eksamensprojekt_2_semester.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {
    @Autowired
    JdbcTemplate template;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Car> getAllCars() {
        String sql = "SELECT * FROM car";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public void createCar(Car car) {
        String sql = "INSERT INTO car (brand, model, monthly_price, steel_price, tax, emission, color, location, damage_status, image, highlighted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, car.getBrand(), car.getModel(), car.getMonthlyPrice(), car.getSteelPrice(), car.getTax(), car.getEmission(), car.getColor(), car.getLocation(), car.getDamageStatus(), car.getImage(), false);
    }

    @Override
    public void updateCar(Car car) {
        String sql = "UPDATE car SET brand=?, model=?, monthly_price=?, steel_price=?, tax=?, emission=?, color=?, location=?, damage_status=?, image=? WHERE id=?";
        template.update(sql, car.getBrand(), car.getModel(), car.getMonthlyPrice(), car.getSteelPrice(), car.getTax(), car.getEmission(), car.getColor(), car.getLocation(), car.getDamageStatus(), car.getImage(), car.getId());
    }

    @Override
    public boolean deleteCar(int id) {
        String sql = "DELETE FROM car WHERE id=?";
        return template.update(sql, id) > 0;
    }

    @Override
    public Car getCarById(int id) {
        String sql = "SELECT * FROM car WHERE id=?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        Car car = template.queryForObject(sql, rowMapper, id);
        return car;
    }


    @Override
    public int getTotalCars() {
        String sql = "SELECT COUNT(*) FROM car";
        return template.queryForObject(sql, Integer.class);
    }

    @Override
    public List<Car> getFirstThreeCars(){
        String sql = "SELECT * FROM car ORDER BY id LIMIT 3";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<Car> getHighlightedCars() {

        String sql = "SELECT * FROM car WHERE highlighted = true";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);

        return jdbcTemplate.query(sql, rowMapper);

    }

    public  List<Car> getNonHightlightedCars() {

        String sql = "SELECT * FROM car WHERE highlighted = false";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);

        return jdbcTemplate.query(sql, rowMapper);


    }

    public void updateHighlightedCars(int oldCarId, int newCarId) {

        String sql1 = "UPDATE car SET highlighted = false WHERE id = ?";
        jdbcTemplate.update(sql1, oldCarId);

        String sql2 = "UPDATE car SET highlighted = true WHERE id = ?";
        jdbcTemplate.update(sql2, newCarId);

    }

    @Override
    public List<Car> getCarByAvailabilityAndLocation(String availability, String location) {

        String sql = "SELECT c.* FROM car c ";
        List<Object> params = new ArrayList<>();

        if (availability.equals("Køb")) {

            sql += "LEFT JOIN purchase_contract p ON c.id = p.car_id " +
                    "WHERE p.car_id IS NULL";


        } else if (availability.equals("Leje")) {

            sql += "LEFT JOIN rental_contract r ON c.id = r.car_id AND r.active = true " +
                    "WHERE r.car_id IS NULL";

        } else {
            sql += "LEFT JOIN rental_contract r ON c.id = r.car_id AND r.active = true " +
                    "LEFT JOIN purchase_contract p ON c.id = p.car_id " +
                    "WHERE r.car_id IS NULL AND p.car_id IS NULL";
        }

        if (!(location.equals("Alle"))) {

            sql += " AND c.location = ?";
            params.add(location);

        }

        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql, rowMapper, params.toArray());

    }


}
