package main.lesson_33_Arrays.homework.employee.dao;

import main.lesson_33_Arrays.homework.employee.model.Employee;

public interface Company {

    public static final String NAME = "Ait";

    boolean addEmployee(Employee employee);

    Employee removeEmployee(int id);

    Employee findEmployee(int id);

    int quantity();

    double totalSalary();

    default double avgSalary() {
        return totalSalary() / quantity();
    }

    double totalSales();

    void printEmployees();

    Employee[] findEmployeesHoursGreaterThan(int hours);

    Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary);
}
