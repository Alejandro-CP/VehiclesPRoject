package com.vehicles.project;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) throws Exception {
		super(plate, brand, color);
	}
	public void addWheels(Wheel frontWheel, Wheel rearWheel) throws Exception{
		if(frontWheel == null || rearWheel == null) throw new Exception("Les rodes de la motocicleta no poden ser nul·les.");
		this.wheels.add(frontWheel);
		this.wheels.add(rearWheel);
	}

}
