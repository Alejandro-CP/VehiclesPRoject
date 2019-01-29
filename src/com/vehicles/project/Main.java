package com.vehicles.project;

import java.util.*;

public class Main {
	
	public static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			switch(selectVehicle()) {
			case 1:
				System.out.println("Comencem a crear una motocicleta.");
				Bike bike1 = createBike();
				addVehicleWheels(bike1,2);
				break;
			case 2:
				System.out.println("Comencem a crear un cotxe.");
				Car car1 = createCar();
				addVehicleWheels(car1,4);
				break;
			default:
				System.out.println("No es reconeix el vehicle sel·leccionat. No es pot crear cap vehicle.");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	private static int selectVehicle() {
		System.out.println("Sel·lecconi el número del tipus de vehícle que dessitja crear:\n"
				+ "1) Motocicleta\n" + "2) Cotxe");
		return Integer.parseInt(userInput.nextLine());
	}

	private static Bike createBike() throws Exception {
		String plate = readVehiclePlate();
		String brand = readVehicleBrand();
		String color = readVehicleColor();
		return new Bike(plate, brand, color);
	}
	
	private static void addVehicleWheels(Vehicle v, int wheels) throws Exception {
		if(wheels == 2) {
			addBikeWheels((Bike) v);
		}else if(wheels == 4) {
			addCarWheels((Car) v);
		}else {
			throw new Exception("El número de rodes a afegir és incorrecte.");
		}
	}
	
	private static void addBikeWheels(Bike b) throws Exception {
		System.out.println("Roda davantera:");
		Wheel frontWheel = new Wheel(wheelBrand(), wheelDiameter());
		System.out.println("Roda trasera:");
		Wheel rearWheel = new Wheel(wheelBrand(), wheelDiameter());
		b.addWheels(frontWheel, rearWheel);
	}
	
	private static String readVehiclePlate() {
		System.out.println("Introdueixi la matrícula:");
		return userInput.nextLine();
	}
	
	private static String readVehicleBrand() {
		System.out.println("Introdueixi la marca:");
		return userInput.nextLine();
	}
	
	private static String readVehicleColor() {
		System.out.println("Introdueixi el color:");
		return userInput.nextLine();
	}
	
	private static Car createCar() throws Exception {
		String plate = readVehiclePlate();
		String brand = readVehicleBrand();
		String color = readVehicleColor();
		return new Car(plate, brand, color);
	}
	
	private static void addCarWheels(Car c) throws Exception{
		List <Wheel> frontWheels = new ArrayList <>();
		List <Wheel> rearWheels = new ArrayList <>();
		infoCarRearWheels(rearWheels);
		infoCarFrontWheels(frontWheels);
		c.addWheels(frontWheels, rearWheels);
	}
	
	private static void infoCarFrontWheels(List <Wheel> wheels) throws Exception {
		System.out.println("Roda davantera esquerra:");
		wheels.add(new Wheel(wheelBrand(), wheelDiameter()));
		System.out.println("Roda davantera dreta:");
		wheels.add(new Wheel(wheelBrand(), wheelDiameter()));
	}
	
	private static void infoCarRearWheels(List <Wheel> wheels) throws Exception {
		System.out.println("Roda trasera esquerra:");
		wheels.add(new Wheel(wheelBrand(), wheelDiameter()));
		System.out.println("Roda trasera dreta:");
		wheels.add(new Wheel(wheelBrand(), wheelDiameter()));
	}
	
	private static String wheelBrand() {
		System.out.println("Introdueixi marca de la roda:");
		return userInput.nextLine();
	}
	
	private static double wheelDiameter() {
		System.out.println("Introdueixi diametre de la roda:");
		return Double.parseDouble(userInput.nextLine());
	}	
}
