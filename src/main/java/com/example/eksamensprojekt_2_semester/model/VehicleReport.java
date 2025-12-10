package com.example.eksamensprojekt_2_semester.model;

public class VehicleReport {

    private int id;
    private int totalCost;

    public VehicleReport(int id, int totalCost) {
        this.id = id;
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

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
