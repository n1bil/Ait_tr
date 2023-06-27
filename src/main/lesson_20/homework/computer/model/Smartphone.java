package main.lesson_20.homework2.computer.model;

public class Smartphone extends Laptop {

    private long imei;

    public Smartphone(long barCode ,String cpu, int ram, int ssd, String brand, double hours, double weight, long imei) {
        super(barCode ,cpu, ram, ssd, brand, hours, weight);
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "barCode=" + barCode +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", ssd=" + ssd +
                ", brand='" + brand + '\'' +
                ", hours=" + hours +
                ", weight=" + weight +
                ", imei=" + imei +
                '}';
    }
}
