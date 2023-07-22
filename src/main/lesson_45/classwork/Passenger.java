package main.lesson_45.classwork;

public class Passenger {

    private String name;

    private Bus bus;

    private boolean inBus; // true -

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void goToBus(Bus bus) {
        if (inBus) {
            System.err.println(this.name + ": I can't to seat iin the bus");
        }
        if (bus == null) {
            System.err.println(this.name + ": I can't go to non-existent bus");
            return;
        }

        if (bus.isGoing()) {
            System.err.println(this.name + ": I can't seat to the bus");
        }

        if (bus.isFull()) {
            System.err.println(this.name + "There are no seats");
        }

        this.bus = bus;
        bus.addPassenger(this); // говорим автобусу, чтобы он нас добавил
        this.inBus = true;
        // в качестве пассажиров
    }

    public void sayAbout() {
        if (inBus) {
            System.out.println(name + ": ura, I'm in the bus <" + this.bus.getNumber() + ">");
        } else {
            System.out.println(name + ": is waiting for the bus");
        }
    }
}
