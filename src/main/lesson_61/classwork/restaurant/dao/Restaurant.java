package main.lesson_61.classwork.restaurant.dao;

import main.lesson_61.classwork.restaurant.model.Client;
import main.lesson_61.classwork.restaurant.model.Table;

import java.util.List;

public interface Restaurant {

    String welcome();

    List<Table> freeTable();

    boolean reserveTable(Client client);

    boolean removeReservation(long phoneNumber);
}
