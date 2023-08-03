package main.lesson_55_FunctionalProgramming.homework.company_employee.dao;

import main.lesson_55_FunctionalProgramming.homework.company_employee.model.Employee;

import java.util.List;

public interface Company {

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

    List<Employee> findEmployeesHoursGreaterThan(int hours);

    List<Employee> findEmployeesSalaryRange(int minSalary, int maxSalary);
}
