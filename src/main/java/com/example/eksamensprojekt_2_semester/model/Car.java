package com.example.eksamensprojekt_2_semester.model;

import java.util.Base64;

public class Car {

    private int id;
    private String brand;
    private String model;
    private double monthlyPrice;
    private boolean highlighted;
    private int steelPrice;
    private int tax;
    private int emission;
    private String color;
    private String location;
    private boolean damageStatus;

    // Java maps BLOB to byte[] in jdbc
    private byte[] image;

    public Car() {}

    public Car(int id, String brand, String model, double monthlyPrice, boolean highlighted, int steelPrice, int tax, int emission, String color, String location, boolean damageStatus) {
        this.id = id;
        this.brand = brand;
        this.model = model;
	this.monthlyPrice = monthlyPrice;
	this.highlighted = highlighted;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getDamageStatus() {
        return damageStatus;
    }

    public void setDamageStatus(boolean damageStatus) {
        this.damageStatus = damageStatus;
    }

    public byte[] getImage() {
	return image;
    }

    public void setImage(byte[] image) {
	this.image = image;
    }

    public String getImageBase64() {
	if (image == null) return null;
	return Base64.getEncoder().encodeToString(image);
    }

    public double getMonthlyPrice() {
	return monthlyPrice;
    }

    public void setMonthlyPrice(double monthlyPrice) {
	this.monthlyPrice = monthlyPrice;
    }

    public boolean isHighlighted() {
	return highlighted;
    }

    public void setHighlighted(boolean highlighted) {
	this.highlighted = highlighted;
    }
}
