package main.lesson_33_Arrays.homework.employee.dao;

import main.lesson_33_Arrays.homework.employee.model.Employee;

import java.util.function.Predicate;

public class HoursPredicate implements Predicate<Employee> {
    private int hours;

    public HoursPredicate(int hours) {
        this.hours = hours;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.getHours() > hours;
    }
}
