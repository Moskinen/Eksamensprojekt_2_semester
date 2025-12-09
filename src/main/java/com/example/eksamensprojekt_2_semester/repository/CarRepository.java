package com.example.eksamensprojekt_2_semester.repository;

import com.example.eksamensprojekt_2_semester.model.Car;

import java.util.List;

public interface CarRepository {

    List<Car> getAllCars();

    void createCar(Car car);

    void updateCar(Car car);

    boolean deleteCar(int id);

    Car getCarById(int id);

    int getTotalCars();

    List<Car> getFirstThreeCars();

    List<Car> getHighlightedCars();

    void updateHighlightedCars(int oldCarId, int newCarId);

    List<Car> getCarByAvailabilityAndLocation(String availability, String location);



}
