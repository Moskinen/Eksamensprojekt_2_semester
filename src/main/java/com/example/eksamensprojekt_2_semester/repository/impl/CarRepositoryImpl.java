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
        String sql = "INSERT INTO car (brand, model, steel_price, tax, emission, color, location, damage_status, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, car.getBrand(), car.getModel(), car.getSteelPrice(), car.getTax(), car.getEmission(), car.getColor(), car.getLocation().name(), car.getDamageStatus(), car.getImage());
    }

    @Override
    public void updateCar(Car car) {
        String sql = "UPDATE car SET brand=?, model=?, steel_price=?, tax=?, emission=?, color=?, location=?, damage_status=?, image=? WHERE id=?";
        template.update(sql, car.getBrand(), car.getModel(), car.getSteelPrice(), car.getTax(), car.getEmission(), car.getColor(), car.getLocation().name(), car.getDamageStatus(), car.getImage(), car.getId());
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
    public int getTotalCars(){
        String sql = "SELECT COUNT(*) FROM car";
        return template.queryForObject(sql, Integer.class);
    }


}
