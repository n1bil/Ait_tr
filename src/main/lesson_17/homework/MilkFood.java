package main.lesson_17.homework;

public class MilkFood extends Food {

    private String milkType;
    private double fat;

    public MilkFood(double price, String name, long barCode, String expDate, String milkType, double fat) {
        super(price, name, barCode, expDate);
        this.milkType = milkType;
        this.fat = fat;
    }

    @Override
    public String toString() {
        return super.toString() + " milkType='" + milkType + '\'' + ", fat=" + fat;
    }
}
