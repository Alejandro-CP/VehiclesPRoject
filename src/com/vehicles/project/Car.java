package com.vehicles.project;

import java.util.List;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) throws Exception {
		super(plate, brand, color);
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		if(frontWheels == null || backWheels == null) throw new Exception("Les rodes del cotxe no poden ser nul·les."); 
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception("Un cotxe ha de tenir dues rodes per eix.");

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception("Les dues rodes del mateix eix han de ser iguals.");

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
	
	@Override
	public int getFrontWheelsQuantity() {
		return 2;
	}
	
	@Override
	public int getRearWheelsQuantity() {
		return 2;
	}

}
