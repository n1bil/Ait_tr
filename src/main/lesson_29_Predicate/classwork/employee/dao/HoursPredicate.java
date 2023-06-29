package main.lesson_29_Predicate.classwork.employee.dao;

import main.lesson_29_Predicate.classwork.employee.model.Employee;

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
