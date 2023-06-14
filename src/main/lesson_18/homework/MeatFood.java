package main.lesson_18.homework;

public class MeatFood extends Food {

    private String meatType;

    public MeatFood(double price, String name, long barCode, String expDate, String meatType) {
        super(price, name, barCode, expDate);
        this.meatType = meatType;
    }

    @Override
    public String toString() {
        return super.toString() + " meatType='" + meatType + '\'';
    }
}
