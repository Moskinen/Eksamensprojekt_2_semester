package com.example.eksamensprojekt_2_semester.model;

import com.example.eksamensprojekt_2_semester.model.enums.Location;

public class Car {

    int id;
    String brand;
    String model;
    int steelPrice;
    int tax;
    int emission;
    String color;
    Location location;
    boolean damageStatus;

    public Car(int id, String brand, String model, int steelPrice, int tax, int emission, String color, Location location, boolean damageStatus) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.steelPrice = steelPrice;
        this.tax = tax;
        this.emission = emission;
        this.color = color;
        this.location = location;
        this.damageStatus = damageStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSteelPrice() {
        return steelPrice;
    }

    public void setSteelPrice(int steelPrice) {
        this.steelPrice = steelPrice;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getEmission() {
        return emission;
    }

    public void setEmission(int emission) {
        this.emission = emission;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean getDamageStatus() {
        return damageStatus;
    }

    public void setDamageStatus(boolean damageStatus) {
        this.damageStatus = damageStatus;
    }
}
