package com.example.eksamensprojekt_2_semester.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eksamensprojekt_2_semester.model.Car;
import com.example.eksamensprojekt_2_semester.repository.CarRepository;

@Service
public class CarService {
	private final CarRepository carRepository;

	@Autowired
	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public List<Car> getAllCars() {
		return carRepository.getAllCars();
	}

	public void createCar(Car car) {
		carRepository.createCar(car);
	}

	public void updateCar(Car car) {
		carRepository.updateCar(car);
	}

	public boolean deleteCar(int id) {
		return carRepository.deleteCar(id);
	}

	public Car getCarById(int id) {
		return carRepository.getCarById(id);
	}

	public int  getTotalCars(){
		return carRepository.getTotalCars();
	}
}
