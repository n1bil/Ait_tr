package main.lesson_52_HashSet_TreeSet.classwork.company_employee.dao;

import main.lesson_52_HashSet_TreeSet.classwork.company_employee.model.Employee;

import java.util.ArrayList;

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

    ArrayList<Employee> findEmployeesHoursGreaterThan(int hours);

    ArrayList<Employee> findEmployeesSalaryRange(int minSalary, int maxSalary);
}
