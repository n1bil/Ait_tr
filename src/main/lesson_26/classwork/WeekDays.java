package main.lesson_26.classwork;

public class WeekDays {
    public static void main(String[] args) {
        /*
        Сформируйте массив, который хранит названия дней недели при условии, что первый
        рабочий день недели - это Понедельник, а последний - Воскресенье.
        Переопределите этот массив так, чтобы первый рабочим днем недели стало
        Воскресенье, а последним - Суббота
         */

        // declare array
        String[] daysOfWeek = new String[7];

        // fill array
        daysOfWeek[0] = "Monday";
        daysOfWeek[1] = "Tuesday";
        daysOfWeek[2] = "Wednesday";
        daysOfWeek[3] = "Thursday";
        daysOfWeek[4] = "Friday";
        daysOfWeek[5] = "Saturday";
        daysOfWeek[6] = "Sunday";

        String[] week = {"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

        printArray(week);

        String temp = week[week.length - 1];

        for (int i = week.length - 1; i > 0; i--) {
            // будем в цикле переносить элементы массива, 0-й должен стать 1-м, 1-должен стать 2-м и т.д.
            // чтобы не потерять значение элемента, будем использовать переменную temp
            // может начнем с последнего ? 6 -> 0

            week[i] = week[i - 1];
        }
        week[0] = temp;

        printArray(week);
    }

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println();
    }
}
