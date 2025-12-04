package com.example.eksamensprojekt_2_semester.model;

import java.time.LocalDate;

public class RentalContract {
	private int id;
	private LocalDate fromDataTime;
	private LocalDate toDateTime;
	private int maxKm;
	private boolean unlimited;
	private boolean active;
	private int userId;
	private int carId;
	private int vehicleReportId;

	public RentalContract() {
	}

	public RentalContract(int id, LocalDate fromDataTime, LocalDate toDateTime, int maxKm, boolean unlimited,
			boolean active, int userId, int carId, int vehicleReportId) {
		this.id = id;
		this.fromDataTime = fromDataTime;
		this.toDateTime = toDateTime;
		this.maxKm = maxKm;
		this.unlimited = unlimited;
		this.active = active;
		this.userId = userId;
		this.carId = carId;
		this.vehicleReportId = vehicleReportId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFromDataTime() {
		return fromDataTime;
	}

	public void setFromDataTime(LocalDate fromDataTime) {
		this.fromDataTime = fromDataTime;
	}

	public LocalDate getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(LocalDate toDateTime) {
		this.toDateTime = toDateTime;
	}

	public int getMaxKm() {
		return maxKm;
	}

	public void setMaxKm(int maxKm) {
		this.maxKm = maxKm;
	}

	public boolean isUnlimited() {
		return unlimited;
	}

	public void setUnlimited(boolean unlimited) {
		this.unlimited = unlimited;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public int getVehicleReportId() {
		return vehicleReportId;
	}

	public void setVehicleReportId(int vehicleReportId) {
		this.vehicleReportId = vehicleReportId;
	}


}
