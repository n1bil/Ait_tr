package main.lesson_34_Enum_TwoDimensionArray.classwork.enums.model;

public enum Month {
    JAN(31), FEB(28), MAR(31), APR(30), MAY(31), JUN(30),
    JUL(31), AUG(30), SEP(30), OCT(31), NOV(30), DEC(31);
    private int days;
    Month(int days) {
        this.days = days;
    }

    public Month plusMonth(int quantity) {
        int index = ordinal();
        index = index + quantity;
        Month[] values = values();
        return values[index % values.length];
    }

    public int getDays() {
        return days;
    }

    public static String getName(int num) {
        Month[] values = values();
        return values[(num - 1) % values.length].name();
    }
}
