package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) throws Exception {
		super(plate, brand, color);
	}
	public void addWheels(List<Wheel> frontWheel, List<Wheel> rearWheel) throws Exception{
		if(frontWheel == null || rearWheel == null) throw new Exception("Les rodes de la motocicleta no poden ser nul·les.");
		addOneWheel(frontWheel);
		addOneWheel(rearWheel);
	}
	
	public void addOneWheel(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 1)
			throw new Exception("Una motocicleta només pot tenir una roda per eix.");
		
		this.wheels.add(wheels.get(0));
	}
	
	@Override
	public int getFrontWheelsQuantity() {
		return 1;
	}
	
	@Override
	public int getRearWheelsQuantity() {
		return 1;
	}

}
