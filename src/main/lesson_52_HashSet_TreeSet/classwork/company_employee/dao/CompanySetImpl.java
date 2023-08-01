package main.lesson_52_HashSet_TreeSet.classwork.company_employee.dao;

import main.lesson_52_HashSet_TreeSet.classwork.company_employee.model.Employee;
import main.lesson_52_HashSet_TreeSet.classwork.company_employee.model.SalesManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class CompanySetImpl implements Company {

    private Set<Employee> employees;
    private int capacity;

    public CompanySetImpl(int capacity) {
        this.capacity = capacity;
        employees = new HashSet<>(capacity);
    }

    // 0(1)
    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        return employees.add(employee);
    }

    // 0(n)
    @Override
    public Employee removeEmployee(int id) {
        Employee victim = findEmployee(id);
        employees.remove(victim);
        return victim;
    }

    // 0(n)
    @Override
    public Employee findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // 0(1)
    @Override
    public int quantity() {
        return employees.size();
    }

    // 0(n)
    @Override
    public double totalSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.calcSalary();
        }
        return sum;
    }
    // 0(n)
    @Override
    public double totalSales() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee instanceof SalesManager) {
                SalesManager salesManager = (SalesManager) employee;
                sum += salesManager.getSalesValue();
            }
        }
        return sum;
    }

    // 0(n)
    @Override
    public void printEmployees() {
        employees.forEach(System.out::println);
    }

    // 0(n)
    @Override
    public ArrayList<Employee> findEmployeesHoursGreaterThan(int hours) {
        return findEmployeesByPredicate(employee -> employee.getHours() > hours);
    }

    // 0(n)
    @Override
    public ArrayList<Employee> findEmployeesSalaryRange(int minSalary, int maxSalary) {
        return findEmployeesByPredicate(employee -> employee.calcSalary() >= minSalary && employee.calcSalary() < maxSalary);
    }

    // 0(n)
    private ArrayList<Employee> findEmployeesByPredicate(Predicate<Employee> predicate) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                result.add(employee);
            }
        }
        return result;
    }
}
