package main.lesson_29_Predicate.homework.cars.dao;

import main.lesson_29_Predicate.homework.cars.model.Car;

import java.util.function.Predicate;

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
        return findCarsByPredicate(car -> car.getModel().equals(model));
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return findCarsByPredicate(car -> car.getCompany().equals(company));
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return findCarsByPredicate(car -> car.getEngine() >= min && car.getEngine() <= max);
    }

    @Override
    public Car[] findCarsByColor(String color) {
        return findCarsByPredicate(car -> car.getColor().equals(color));
    }

    private Car[] findCarsByPredicate(Predicate<Car> carPredicate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (carPredicate.test(cars[i])) {
                count++;
            }
        }
        Car[] foundCars = new Car[count];
        int index = 0;
        for (int i = 0; index < foundCars.length; i++) {
            if (carPredicate.test(cars[i])) {
                foundCars[index] = cars[i];
                index++;
            }
        }
        return foundCars;
    }

}
