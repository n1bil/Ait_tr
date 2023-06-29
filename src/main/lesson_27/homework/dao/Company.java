package main.lesson_27.homework.dao;

import main.lesson_27.homework.model.Employee;

public interface Company {

    boolean addEmployee(Employee employee);

    Employee removeEmployee(int id);

    Employee findEmployee(int id);

    int quantity();

    double totalSalary();

    double avgSalary();

    double totalSales();

    void printEmployees();
}
