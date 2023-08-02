package main.lesson_53_Map.classwork.company_employee.dao;

import main.lesson_53_Map.classwork.company_employee.model.Employee;
import main.lesson_53_Map.classwork.company_employee.model.SalesManager;

import java.util.*;
import java.util.function.Predicate;

public class CompanyMapImpl implements Company {

    private Map<Integer, Employee> employees;
    private int capacity;

    public CompanyMapImpl(int capacity) {
        this.capacity = capacity;
        employees = new HashMap<>(capacity);
    }

    // 0(1)
    @Override
    public boolean addEmployee(Employee employee) {             // 0(1)
        if (employee == null || employees.size() == capacity || employees.containsKey(employee.getId())) {
            return false;
        }
        employees.put(employee.getId(), employee);  // 0(1)
        return true;
    }

    // 0(1)
    @Override
    public Employee removeEmployee(int id) {
        return employees.remove(id);
    }

    // 0(1)
    @Override
    public Employee findEmployee(int id) {
        return employees.get(id);
    }

    @Override
    public int quantity() {
        return employees.size();
    }

    // 0(n)
    @Override
    public double totalSalary() {
        Collection<Employee> values = employees.values();
        double sum = 0;
        for (Employee employee : values) {
            sum += employee.calcSalary();
        }
        return sum;
    }

    // 0(n)
    @Override
    public double totalSales() {
        Collection<Employee> values = employees.values();
        double sum = 0;
        for (Employee employee : values) {
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
        employees.values().forEach(System.out::println);
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
        Collection<Employee> values = employees.values();
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : values) {
            if (predicate.test(employee)) {
                result.add(employee);
            }
        }
        return result;
    }
}
