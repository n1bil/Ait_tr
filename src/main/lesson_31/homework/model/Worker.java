package main.lesson_31.homework.model;

public class Worker extends Employee {

    private int rate;
    private int hours;

    public Worker(String name, int yearOfBirth, int workExperience, boolean hasHigherEducation, int rate, int hours) {
        super(name, yearOfBirth, workExperience, hasHigherEducation);
        this.rate = rate;
        this.hours = hours;
    }

    public int payroll() {
        return rate * hours;
    }
}
