package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) throws Exception {
		checkPlate(plate); 
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
	
	private void checkPlate(String plate) throws Exception {
		checkPlateSize(plate);
		checkPlateNumbers(plate);
		checkPlateLetters(plate);
	}
	
	private void checkPlateSize(String s) throws Exception {
		System.out.println(s.length());
		if((s.length() < 6) || (s.length() > 7)) throw new Exception("Matricula incorrecta.");
	}
	
	private void checkPlateNumbers(String s) throws Exception {
		for(int i = 0; i < 4; i++) {
			if(!Character.isDigit(s.charAt(i))) {
				 throw new Exception("Matricula incorrecta.");
			}
		}
	}
	
	private void checkPlateLetters(String s) throws Exception {
		for(int i = 4; i < s.length(); i++) {
			if(!Character.isLetter(s.charAt(i))) {
				 throw new Exception("Matricula incorrecta.");
			}
		}
	}
	
	public abstract int getFrontWheelsQuantity();
	
	public abstract int getRearWheelsQuantity();
}
