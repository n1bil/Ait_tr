package main.lesson_55_FunctionalProgramming.homework.company_employee.dao;

import main.lesson_55_FunctionalProgramming.homework.company_employee.model.Employee;
import main.lesson_55_FunctionalProgramming.homework.company_employee.model.SalesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CompanyStreamImpl implements Company {
    List<Employee> employees;
    int capacity;

    public CompanyStreamImpl(int capacity) {
        employees = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee != null && employees.size() != capacity && findEmployee(employee.getId()) == null) {
            employees.add(employee);
            return true;
        }
        return false;
    }

    @Override
    public Employee removeEmployee(int id) {
        Employee victim = findEmployee(id);
        if (victim != null) {
            employees.remove(victim);
            return victim;
        }
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }


    @Override
    public double totalSalary() {
        return employees.stream()
                .reduce(0.0, (aDouble, employee) -> aDouble + employee.calcSalary(), Double::sum);
    }

    @Override
    public double totalSales() {
        return employees.stream()
                .filter(employee -> employee instanceof SalesManager)
                .map(employee -> (SalesManager) employee)
                .reduce(0.0, (aDouble, salesManager) -> aDouble + salesManager.getSalesValue(), Double::sum);

    }

    @Override
    public int quantity() {
        return employees.size();
    }

    @Override
    public void printEmployees() {
        employees.forEach(System.out::println);
    }

    @Override
    public List<Employee> findEmployeesHoursGreaterThan(int hours) {
        return findEmployeesByPredicate(employee -> employee.getHours() > hours);
    }

    @Override
    public List<Employee> findEmployeesSalaryRange(int minSalary, int maxSalary) {
        return findEmployeesByPredicate(employee -> employee.calcSalary() >= minSalary && employee.calcSalary() < maxSalary);
    }

    private List<Employee> findEmployeesByPredicate(Predicate<Employee> predicate) {
        return employees.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
