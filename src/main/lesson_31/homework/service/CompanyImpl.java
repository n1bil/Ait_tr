package main.lesson_31.homework.service;

import main.lesson_31.homework.model.Employee;

import java.util.function.Predicate;

public class CompanyImpl implements Company {

    Employee[] employees;
    int size;

    public CompanyImpl(int capacity) {
        employees = new Employee[capacity];
    }

    @Override
    public boolean hireEmployee(Employee employee) {
        if (employee != null && employees.length != size && findEmployee(employee.getName()) == null) {
            employees[size] = employee;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public Employee fireEmployee(String name) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getName().equals(name)) {
                Employee tempEmployee = employees[i];
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                return tempEmployee;
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(String name) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getName().equals(name)) {
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public void printEmployee() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    public Employee[] findEmployeesByWorkExperience(int workExperience) {
        return findEmployeesByPredicate(employee -> employee.getWorkExperience() > workExperience);
    }

    public Employee[] findEmployeesBySalary(int salary) {
        return findEmployeesByPredicate(employee -> employee.payroll() > salary);
    }

    public Employee[] findEmployeesByHigherEducation(boolean isHigherEducation) {
        return findEmployeesByPredicate(employee -> employee.isHasHigherEducation() == isHigherEducation);
    }

    private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(employees[i])) {
                count++;
            }
        }
        Employee[] foundEmployees = new Employee[count];
        int index = 0;
        for (int i = 0; index < foundEmployees.length; i++) {
            if (predicate.test(employees[i])) {
                foundEmployees[index] = employees[i];
                index++;
            }
        }
        return foundEmployees;
    }


}
