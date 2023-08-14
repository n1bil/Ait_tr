package main.lesson_62_DaemonSleepInterruptSynchronizing.classworkHomework.elevator.task;

import main.lesson_62_DaemonSleepInterruptSynchronizing.classworkHomework.elevator.model.Elevator;

public class Truck implements Runnable {

    int nRaces;
    int capacity;
    Elevator lenin;
    Elevator stalin;

    public Truck(int nRaces, int capacity, Elevator lenin, Elevator stalin) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.lenin = lenin;
        this.stalin = stalin;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            synchronized (lenin) {
                lenin.add(capacity / 2);
            }
            synchronized (stalin) {
                stalin.add(capacity / 2);
            }
        }
    }
}
