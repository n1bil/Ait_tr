package main.lesson_27.classwork.employee.dao;

import main.lesson_27.classwork.employee.model.Employee;
import main.lesson_27.classwork.employee.model.SalesManager;

public class CompanyImpl implements Company {

    private Employee[] employees;
    private int size;

    public CompanyImpl(int capacity) {
        employees = new Employee[capacity];
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getId() == employee.getId()) {
                return false;
            }
        }
        if (size < employees.length) {
            employees[size] = employee;
            size++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Employee removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                Employee removedEmployee = employees[i];
                employees[i] = employees[size - 1]; // Заменяем удаленного сотрудника последним сотрудником в массиве
                employees[size - 1] = null; // Обнуляем ссылку на последнего сотрудника
                size--;
                return removedEmployee;
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
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
    public double totalSalary() {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum += employees[i].calcSalary();
            }
        }
        return sum;
    }

    @Override
    public double avgSalary() {
        return totalSalary() / 4;
    }

    @Override
    public double totalSales() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i] instanceof SalesManager) {
                SalesManager salesManager = (SalesManager) employees[i];
                sum += salesManager.getSalesValue();
            }
        }
        return sum;
    }

    @Override
    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}
