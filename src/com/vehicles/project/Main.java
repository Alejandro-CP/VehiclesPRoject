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
				addVehicleWheels(bike1,bike1.getFrontWheelsQuantity(),bike1.getRearWheelsQuantity());
				break;
			case 2:
				System.out.println("Comencem a crear un cotxe.");
				Car car1 = createCar();
				addVehicleWheels(car1,car1.getFrontWheelsQuantity(),car1.getRearWheelsQuantity());
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
	
	private static void addVehicleWheels(Vehicle v, int fWheels, int rWheels) throws Exception {
		List<Wheel> frontWheels = new ArrayList<>();
		List<Wheel> rearWheels = new ArrayList<>();
		
		System.out.println("Afegim rodes traseres:");
		addAxisWheels(rearWheels, rWheels);
		System.out.println("Afegim rodes davanteres:");
		addAxisWheels(frontWheels, fWheels);
		
		if(v instanceof Car) {
			((Car) v).addWheels(frontWheels, rearWheels);;
		}else if(v instanceof Bike) {
			((Bike) v).addWheels(frontWheels, rearWheels);
		}else {
			throw new Exception("Vehicle no reconegut.");
		}
	}
	
	private static void addAxisWheels(List<Wheel> axis, int quantity) throws Exception {
		for(int i = 0; i < quantity; i++) {
			System.out.println("Roda " + (i+1) + ":");
			axis.add(new Wheel(readWheelBrand(), readWheelDiameter()));
		}
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
	
	private static String readWheelBrand() {
		System.out.println("Introdueixi marca de la roda:");
		return userInput.nextLine();
	}
	
	private static double readWheelDiameter() {
		System.out.println("Introdueixi diametre de la roda:");
		return Double.parseDouble(userInput.nextLine());
	}	
}
