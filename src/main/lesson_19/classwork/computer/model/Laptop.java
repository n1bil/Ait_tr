package main.lesson_19.classwork.computer.model;

public class Laptop extends Computer {

    double hours;
    double weight;

    public Laptop(String cpu, int ram, int ssd, String brand, double hours, double weight) {
        super(cpu, ram, ssd, brand);
        this.hours = hours;
        this.weight = weight;
    }

    public void display() {
        super.display();
        System.out.print(", Hours = " + hours + ", Weight = " + weight);
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
                "cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", ssd=" + ssd +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                '}';
    }

    public boolean equals(Object object) {
        if (!(object instanceof Laptop)) {
            return false;
        }
        Laptop other = (Laptop) object;
        return super.equals(other) && hours == other.hours && weight == other.weight;
    }
}
