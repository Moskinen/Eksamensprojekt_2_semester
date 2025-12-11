package com.example.eksamensprojekt_2_semester.model;

import java.time.LocalDateTime;

public class PurchaseContract {
	private int id;
	private int price;
	private LocalDateTime receiveDate;
	private int userId;
	private int carId;

	public PurchaseContract() {
	}

	public PurchaseContract(int id, int price, LocalDateTime receiveDate, int userId, int carId) {
		this.id = id;
		this.price = price;
		this.receiveDate = receiveDate;
		this.userId = userId;
		this.carId = carId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(LocalDateTime receiveDate) {
		this.receiveDate = receiveDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

}
