package main.lesson_41.classwork;

import java.util.ArrayList;
import java.util.Collections;

public class CityBusAppl {
    public static void main(String[] args) {
        ArrayList<Bus> cityBus = new ArrayList<>();

        cityBus.add(new Bus("Mercedes", "24C", 30));
        cityBus.add(new Bus("Citroen", "30", 30));
        cityBus.add(new Bus("Man", "24A", 30));
        cityBus.add(new Bus("Volkswagen", "28D", 30));

        System.out.println(cityBus.size());
        System.out.println(cityBus.contains(new Bus("Mercedes", "24C", 30)));
        int index = cityBus.indexOf(new Bus(null, "24A", 0));
        System.out.println(index);

//        cityBus.indexOf();

        for (Bus bus : cityBus) {
            System.out.println(bus);
        }

        Collections.sort(cityBus);
        for (Bus bus : cityBus) {
            System.out.println(bus);
        }

        int totalCapacity = 0;
        System.out.println("======== Total Capacity ==========");
        for (Bus capacity : cityBus) {
            totalCapacity += capacity.getCapacity();
        }
        System.out.println(totalCapacity);
    }
}
