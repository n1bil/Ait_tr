package main.lesson_57_Collectors.homework;

import java.util.Iterator;
import java.util.List;

public class Pomegranate implements Iterable<Seed> {

    List<Seed> seeds;

    public Pomegranate(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public List<Seed> getSeeds() {
        return seeds;
    }

    @Override
    public Iterator<Seed> iterator() {
        return seeds.iterator();
    }

    @Override
    public String toString() {
        return "Pomegranate{" +
                "seeds=" + seeds +
                '}';
    }
}
