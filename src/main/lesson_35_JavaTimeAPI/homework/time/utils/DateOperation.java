package main.lesson_35_JavaTimeAPI.homework.time.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;

public class DateOperation {

    public static int getAge(String birthDate) {
        LocalDate localDate;
        if (birthDate.contains("-")) {
            localDate = LocalDate.parse(birthDate, DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            localDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return (int) ChronoUnit.YEARS.between(localDate, LocalDate.now());
    }

    public static String[] sortStringDates(String[] dates) {
        //TODO
        DateTimeFormatter df = DateTimeFormatter.ofPattern("[yyyy-MM-dd][dd/MM/yyyy]");

        Comparator<String> comparator = (s1, s2) -> {
            LocalDate localDate1 = LocalDate.parse(s1, df);
            LocalDate localDate2 = LocalDate.parse(s2, df);
            return localDate1.compareTo(localDate2);
        };
        Arrays.sort(dates, comparator);
        return dates;
    }


}
