package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) throws Exception{
		if ((diameter < 0.4) || (diameter > 4)) throw new Exception ("Diametre de roda incorrecte.");
		this.brand = brand;
		this.diameter = diameter;
	}
	
	public boolean equals(Wheel w) {
		return (this.brand.equalsIgnoreCase(w.brand) && (this.diameter == w.diameter));
	}
}
