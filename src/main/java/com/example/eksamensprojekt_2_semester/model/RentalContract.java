package com.example.eksamensprojekt_2_semester.model;

import java.time.LocalDateTime;

public class RentalContract {
	private int id;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private int maxKm;
    private double monthlyPrice;
	private boolean unlimited;
	private boolean active;
	private int userId;
	private int carId;
	private int vehicleReportId;

	public RentalContract() {
	}

	public RentalContract(int id, LocalDateTime fromDateTime, LocalDateTime toDateTime, int maxKm, boolean unlimited,
			boolean active, int userId, int carId, int vehicleReportId, double monthlyPrice) {
		this.id = id;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.maxKm = maxKm;
		this.unlimited = unlimited;
		this.active = active;
		this.userId = userId;
		this.carId = carId;
		this.vehicleReportId = vehicleReportId;
        this.monthlyPrice = monthlyPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public LocalDateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(LocalDateTime toDateTime) {
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

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }
}
