package main.lesson_61.classwork.restaurant.model;

import main.lesson_61.classwork.restaurant.utils.Utils;

import java.time.LocalDateTime;
import java.util.Objects;

public class Table {

    private int id;
    private boolean isOccupied;
    private Client client;
    private LocalDateTime now;

    public Table(int number) {
        this.id = number;
        isOccupied = false;
    }

    public int getId() {
        return id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setClient(Client client) {
        this.client = client;
        this.now = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return id == table.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", isOccupied=" + isOccupied +
                ", client=" + client +
                ", now=" + now.format(Utils.parseData()) +
                '}';
    }
}
