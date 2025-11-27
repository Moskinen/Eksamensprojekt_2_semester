package com.example.eksamensprojekt_2_semester.repository;

import com.example.eksamensprojekt_2_semester.model.Car;

import java.util.List;

public interface CarRepository {

    public List<Car> getAllCars();

    public Car updateCar(Car car);

    public Car deleteCar(int id);

}
