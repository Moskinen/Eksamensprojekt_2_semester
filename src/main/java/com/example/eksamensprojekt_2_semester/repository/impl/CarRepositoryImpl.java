package com.example.eksamensprojekt_2_semester.repository.impl;
import com.example.eksamensprojekt_2_semester.model.Car;
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

    @Override
    public List<Car> getAllCars() {
        String sql = "SELECT * FROM car";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public void createCar(Car car) {
        String sql = "INSERT INTO car (id, brand, model, steel_price, tax, emission, color, location, damage_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, car.getId(), car.getBrand(), car.getModel(), car.getSteelPrice(), car.getTax(), car.getEmission(), car.getColor(), car.getLocation(), car.isDamageStatus());
    }

    @Override
    public void updateCar(Car car) {
        String sql = "UPDATE car SET brand=?, model=?, steel_price=?, tax=?, emission=?, color=?, location=?, damage_status=? WHERE id=?";
        template.update(sql, car.getBrand(), car.getModel(), car.getSteelPrice(), car.getTax(), car.getEmission(), car.getColor(), car.getLocation(), car.isDamageStatus(), car.getId());
    }

    @Override
    public boolean deleteCar(int id) {
        String sql = "DELETE FROM car WHERE id=?";
        return template.update(sql, id) > 0;
    }


}
