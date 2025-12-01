package com.example.eksamensprojekt_2_semester.model;

public class Damage {

    int id;
    String name;
    int price;
    int vehicleReportId;

    public Damage() {
    }

    public Damage(int id, String name, int price, int vehicleReportId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.vehicleReportId = vehicleReportId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVehicleReportId() {
        return vehicleReportId;
    }

    public void setVehicleReportId(int vehicleReportId) {
        this.vehicleReportId = vehicleReportId;
    }
}
