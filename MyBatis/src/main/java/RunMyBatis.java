package main.java;

import java.util.List;

public class RunMyBatis {
	public static void main(String[] args) {
		CarDAO carDAO = new CarDAO();
		Car car = new Car();
		
		//Insert a new car into the database
		car = new Car();
		car.setId(3);
		car.setBrand("Honda");
		car.setType("Civic");
		car.setDoor(3);
		car.setYear(2014);
		car.setEngineCode("D14W7");
		car.setTransmission("manual5");
		car.setPrice(1200000);
		carDAO.save(car);
		System.out.println("Added new car into the database with id: 3");
		System.out.println("----------------------------------------");
		
		//Select the list of cars
		List<Car> cars = carDAO.getAllCar();
		System.out.println("List of the cars: ");
		for(Car c: cars) {
			printCar(c);
		}
		
		System.out.println("----------------------------------------");
		
		//Delete the car with id: 3
		carDAO.delete(3);
		System.out.println("Deleted the car with id: 3");
		
		System.out.println("----------------------------------------");
		
		cars = carDAO.getAllCar();
		System.out.println("List of the cars after the delete: ");
		for(Car c: cars) {
			printCar(c);
		}
		
		System.out.println("----------------------------------------");
		
		//Update the price of the car with id: 1
		car = carDAO.getCar(1);
		car.setPrice(450000);
		carDAO.update(car);
		System.out.println("Updated the price of the car with id: 1");
		
		System.out.println("----------------------------------------");
		
		//Select car with id:1 after the update
		System.out.println("Car after the update: ");
		printCar(carDAO.getCar(1));
	}
	
	public static void printCar(Car car) {
		System.out.println("id: " + car.getId() + ", brand: " + car.getBrand() + ", type: " 
				+ car.getType() + ", door: " + car.getDoor() + ", year: " + car.getYear()
				+ ", engineCode: " + car.getEngineCode() + ", transmission: " + car.getTransmission()
				+ ", price: " + car.getPrice());
	}
}
