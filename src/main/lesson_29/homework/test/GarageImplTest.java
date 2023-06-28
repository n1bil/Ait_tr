package main.lesson_29.homework.test;

import main.lesson_29.homework.cars.dao.Garage;
import main.lesson_29.homework.cars.dao.GarageImpl;
import main.lesson_29.homework.cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplTest {

    Garage garage;
    Car[] cars;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(5);
        cars = new Car[6];
        cars[0] = new Car("823D33OO", "X5", "BMW", 1.6, "Black");
        cars[1] = new Car("523C311O", "Astra", "Ferrari", 1.8, "Dark blue");
        cars[2] = new Car("22AA322O", "X5", "Ferrari", 1.6, "Gray");
        cars[3] = new Car("773XD555", "350z", "Nissan", 1.4, "Black");
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }

    @Test
    void addCar() {
        assertFalse(garage.addCar(null));
        assertFalse(garage.addCar(cars[2]));
        cars[4] = new Car("913W6565", "Camaro", "Chevrolet", 1.6, "Yellow");
        assertTrue(garage.addCar(cars[4]));
        cars[5] = new Car("YW23499L", "Golf", "Volkswagen", 1.6, "Brown");
        assertFalse(garage.addCar(cars[5]));
    }

    @Test
    void removeCar() {
        assertEquals(cars[3], garage.removeCar("773XD555"));
        assertNull(garage.removeCar("773XD555"));
    }

    @Test
    void findCarByRegNumber() {
        assertEquals(cars[2], garage.findCarByRegNumber("22AA322O"));
        assertNull(garage.findCarByRegNumber(null));
    }

    @Test
    void findCarsByModel() {
        Car[] expected = garage.findCarsByModel("X5");
        Car[] actual = {cars[0], cars[2]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByCompany() {
        Car[] expected = garage.findCarsByCompany("Ferrari");
        Car[] actual = {cars[1], cars[2]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByEngine() {
        Car[] expected = garage.findCarsByEngine(1.6, 1.8);
        Car[] actual = {cars[0], cars[1], cars[2]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByColor() {
        Car[] expected = garage.findCarsByColor("Black");
        Car[] actual = {cars[0], cars[3]};
        assertArrayEquals(expected, actual);
    }
}