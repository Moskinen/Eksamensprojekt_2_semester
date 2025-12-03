package com.example.eksamensprojekt_2_semester.model;

public class VehicleReport {

    int id;
    int carId;
    int totalCost;

    public VehicleReport(int id, int carId, int totalCost) {
        this.id = id;
        this.carId = carId;
        this.totalCost = totalCost;
    }

    public VehicleReport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
