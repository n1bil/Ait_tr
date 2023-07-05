package main.lesson_33_Arrays.homework.employee.dao;

import main.lesson_33_Arrays.homework.employee.model.Employee;
import main.lesson_33_Arrays.homework.employee.model.SalesManager;

import java.util.Arrays;
import java.util.function.Predicate;

public class CompanyImpl implements Company {

    private Employee[] employees;
    private int size;

    public CompanyImpl(int capacity) {
        employees = new Employee[capacity];
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee != null && size != employees.length && findEmployee(employee.getId()) == null) {
            employees[size] = employee;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public Employee removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                Employee temp = employees[i];
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                size--;
                employees[size] = null;
                return temp;
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
        for (int i = 0; i < size; i++) {
            sum += employees[i].calcSalary();
        }
        return sum;
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

    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
       return findEmployeesByPredicate(employee -> employee.getHours() > hours);
    }

    @Override
    public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) {
        return findEmployeesByPredicate(employee -> employee.calcSalary() >= minSalary && employee.calcSalary() < maxSalary);
    }

    private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
//        int countEmployees = 0;
//        for (int i = 0; i < size; i++) {
//            if (predicate.test(employees[i])) {
//                countEmployees++;
//            }
//        }
        Employee[] result = new Employee[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(employees[i])) {
                result[index++] = employees[i];
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}
