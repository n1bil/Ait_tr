package main.lesson_61.classwork.restaurant.dao;

import main.lesson_61.classwork.restaurant.model.Client;
import main.lesson_61.classwork.restaurant.model.Table;
import main.lesson_61.classwork.restaurant.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class RestaurantImpl implements Restaurant {

    List<Table> tables;

    public RestaurantImpl() {
        tables = new ArrayList<>(5);
        for (int i = 1; i <= 5; i++) {
            tables.add(new Table(i));
        }
    }

    @Override
    public String welcome() {
        if (freeTable().size() != 0) {
            return "Welcome! There are currently " + freeTable().size() +" free tables";
        } else {
            return "Sorry. There are no free tables";
        }
    }

    @Override
    public List<Table> freeTable() {
        List<Table> freeTables = new ArrayList<>();
        for (Table table : tables) {
            if (!table.isOccupied()) {
                freeTables.add(table);
            }
        }
        return freeTables;
    }

    @Override
    public boolean reserveTable(Client client) {
        if (client == null) {
            return false;
        }
        for (Table table : tables) {
            if (table.getClient() != null && table.getClient().getPhoneNumber() == client.getPhoneNumber()) {
                System.out.println("You have already reserved a table with this phone number");
                return false;
            }
            if (!table.isOccupied()) {
                table.setClient(client);
                table.setOccupied(true);
                Utils.writeClientToFile(table);
                System.out.println("Accepted. Have a good time in our restaurant");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeReservation(long phoneNumber) {
        for (Table table : tables) {
            if (table.getClient() != null && table.getClient().getPhoneNumber() == phoneNumber) {
                table.setClient(null);
                table.setOccupied(false);
                Utils.writeClientToFile(table);
                System.out.println("Accepted. Come to us again");
                return true;
            }
        }
        System.out.println("You are not in the reservation with this phone number");
        return false;
    }
}
