package main.lesson_16.classwork;

public class Car {
    private String vin;
    private int price;
    private Engine engine;
    private int speed;
    private int year;
    private String brand;
    private String color;

    public Car(String vin, int price, Engine engine, int speed, int year, String brand, String color) {
        this.vin = vin;
        this.price = price;
        this.engine = engine;
        this.speed = speed;
        this.year = year;
        this.brand = brand;
        this.color = color;
    }

    public boolean engineStart() {
        return true;
    }



    public String getVin() {
        return vin;
    }

    public int getPrice() {
        return price;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getSpeed() {
        return speed;
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", price=" + price +
                ", engine=" + engine +
                ", speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
