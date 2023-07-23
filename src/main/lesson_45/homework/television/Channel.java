package main.lesson_45.homework.television;

import java.util.List;

public class Channel {

    private String name;
    private int number;
    private List<Programmes> programmes;

    public Channel(String name, int number, List<Programmes> programmes) {
        this.name = name;
        this.number = number;
        this.programmes = programmes;
    }

    public int getNumber() {
        return number;
    }

    public List<Programmes> getProgrammes() {
        return programmes;
    }
}
