package com.example.eksamensprojekt_2_semester.repository;

import com.example.eksamensprojekt_2_semester.model.User;

import java.util.List;

public interface CarRepository {

    public List<User> getAllCars();

    public User updateCar(User car);

    public User deleteCar(int id);

}
