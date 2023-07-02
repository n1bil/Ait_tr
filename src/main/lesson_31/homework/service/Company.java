package main.lesson_31.homework.service;

import main.lesson_31.homework.model.Employee;

public interface Company {

    boolean hireEmployee(Employee employee);

    Employee fireEmployee(String name);

    Employee findEmployee(String name);

    int quantity();

    void printEmployee();

    Employee[] findEmployeesByWorkExperience(int workExperience);

    Employee[] findEmployeesBySalary(int salary);

    Employee[] findEmployeesByHigherEducation(boolean isHigherEducation);
}
