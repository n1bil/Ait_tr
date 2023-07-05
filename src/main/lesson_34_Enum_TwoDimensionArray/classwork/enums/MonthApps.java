package main.lesson_34_Enum_TwoDimensionArray.classwork.enums;

import main.lesson_34_Enum_TwoDimensionArray.classwork.enums.model.Month;

public class MonthApps {
    public static void main(String[] args) {
        Month month = Month.DEC;
        System.out.println(month);
        System.out.println(month.plusMonth(3));
        System.out.println(Month.getName(7));
        System.out.println(Month.JUL.getDays());
    }
}
