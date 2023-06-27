package main.lesson_20.homework.computer.model;

public class Laptop extends Computer {

    double hours;
    double weight;

    public Laptop(long barCode, String cpu, int ram, int ssd, String brand, double hours, double weight) {
        super(barCode ,cpu, ram, ssd, brand);
        this.hours = hours;
        this.weight = weight;
    }

    public double getHours() {
        return hours;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "barCode=" + barCode +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", ssd=" + ssd +
                ", brand='" + brand + '\'' +
                ", hours=" + hours +
                ", weight=" + weight +
                '}';
    }
}
