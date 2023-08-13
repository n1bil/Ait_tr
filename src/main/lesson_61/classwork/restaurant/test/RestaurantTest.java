package main.lesson_61.classwork.restaurant.test;

import main.lesson_61.classwork.restaurant.dao.Restaurant;
import main.lesson_61.classwork.restaurant.dao.RestaurantImpl;
import main.lesson_61.classwork.restaurant.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    Restaurant restaurant;

    @BeforeEach
    void setUp() {
        restaurant = new RestaurantImpl();
        restaurant.reserveTable(new Client("David", 340203244));
        restaurant.reserveTable(new Client("David", 340203245));
        restaurant.reserveTable(new Client("David", 340203246));
        restaurant.reserveTable(new Client("David", 340203247));
    }

    @Test
    void welcome() {
        assertEquals("Welcome! There are currently " + restaurant.freeTable().size() +" free tables", restaurant.welcome());
    }

    @Test
    void welcomeIfFiveClients() {
        restaurant.reserveTable(new Client("David", 340203248));
        assertEquals("Sorry. There are no free tables", restaurant.welcome());
    }

    @Test
    void freeTable() {
        assertEquals(1, restaurant.freeTable().size());
    }

    @Test
    void reserveTable() {
        assertEquals(1, restaurant.freeTable().size());
        assertFalse(restaurant.reserveTable(new Client("Michael", 340203244)));
        assertEquals(1, restaurant.freeTable().size());
        assertTrue(restaurant.reserveTable(new Client("Steve", 340203255)));
        assertEquals(0, restaurant.freeTable().size());
        assertFalse(restaurant.reserveTable(new Client("Shawn", 345412348)));
    }

    @Test
    void removeReservation() {
        assertTrue(restaurant.removeReservation(340203244));
    }
}