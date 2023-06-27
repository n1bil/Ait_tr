package main.lesson_28.homework.cars.dao;

import main.lesson_28.homework.cars.model.Car;

public class GarageImpl implements Garage {

    private Car[] cars;

    private int size;

    public GarageImpl(int capacity) {
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (car != null && size != cars.length && findCarByRegNumber(car.getRegNumber()) == null) {
            cars[size] = car;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                Car tempCar = cars[i];
                cars[i] = cars[size - 1];
                cars[size - 1] = null;
                size--;
                return tempCar;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getModel().equals(model)) {
                count++;
            }
        }
        Car[] foundCars = new Car[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getModel().equals(model)) {
                foundCars[index] = cars[i];
                index++;
            }
        }
        return foundCars;
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getCompany().equals(company)) {
                count++;
            }
        }
        Car[] foundCars = new Car[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getCompany().equals(company)) {
                foundCars[index] = cars[i];
                index++;
            }
        }
        return foundCars;
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getEngine() >= 1.6 && cars[i].getEngine() <= 1.8) {
                count++;
            }
        }
        Car[] foundCars = new Car[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getEngine() >= 1.6 && cars[i].getEngine() <= 1.8) {
                foundCars[index] = cars[i];
                index++;
            }
        }
        return foundCars;
    }

    @Override
    public Car[] findCarsByColor(String color) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getColor().equals(color)) {
                count++;
            }
        }
        Car[] foundCars = new Car[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getColor().equals(color)) {
                foundCars[index] = cars[i];
                index++;
            }
        }
        return foundCars;
    }
}
