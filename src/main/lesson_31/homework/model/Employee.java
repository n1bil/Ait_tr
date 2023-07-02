package main.lesson_31.homework.model;

public abstract class Employee {
    private String name;
    private int yearOfBirth;
    private int workExperience;
    private boolean hasHigherEducation;

    public Employee(String name, int yearOfBirth, int workExperience, boolean hasHigherEducation) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.workExperience = workExperience;
        this.hasHigherEducation = hasHigherEducation;
    }

    public abstract int payroll();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public boolean isHasHigherEducation() {
        return hasHigherEducation;
    }

    public void setHasHigherEducation(boolean hasHigherEducation) {
        this.hasHigherEducation = hasHigherEducation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", workExperience=" + workExperience +
                ", hasHigherEducation=" + hasHigherEducation +
                '}';
    }
}
