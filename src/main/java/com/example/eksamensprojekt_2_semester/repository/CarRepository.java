package com.example.eksamensprojekt_2_semester.repository;

import com.example.eksamensprojekt_2_semester.model.Car;

import java.util.List;

public interface CarRepository {

    public List<Car> getAllCars();

    public void createCar(Car car);

    public void updateCar(Car car);

    public boolean deleteCar(int id);

}
