package com.lti.resource;

import java.time.LocalDate;
import java.util.List;

public class Pnr {

	private int pnNo;
	private int trainNo;
	private LocalDate travelDate;
	
	private List<Passengers> passengers;

	public Pnr(int pnNo, int trainNo, LocalDate travelDate) {
		super();
		this.pnNo = pnNo;
		this.trainNo = trainNo;
		this.travelDate = travelDate;
	}

	public int getPnNo() {
		return pnNo;
	}

	public void setPnNo(int pnNo) {
		this.pnNo = pnNo;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public List<Passengers> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}
}
