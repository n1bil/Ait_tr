package main.lesson_57_Collectors.homework;

import java.util.Iterator;
import java.util.List;

public class Box implements Iterable<Pomegranate> {

    String name;
    List<Pomegranate> granates;

    public Box(String name, List<Pomegranate> granates) {
        this.name = name;
        this.granates = granates;
    }

    public List<Pomegranate> getGranates() {
        return granates;
    }

    public String getName() {
        return name;
    }

    @Override
    public Iterator<Pomegranate> iterator() {
        return granates.iterator();
    }

    @Override
    public String toString() {
        return "Box{" +
                "name='" + name + '\'' +
                ", granates=" + granates +
                '}';
    }
}
