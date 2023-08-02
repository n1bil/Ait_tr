package main.lesson_53_Map.classwork.company_employee.dao;

import main.lesson_53_Map.classwork.company_employee.model.Employee;
import main.lesson_53_Map.classwork.company_employee.model.SalesManager;

import java.util.ArrayList;

public class CompanyImpl implements Company {

    private ArrayList<Employee> employees;

    public CompanyImpl() {
        employees = new ArrayList<>();
    }
    // && findEmployee(employee.getId()) == null
    @Override
    public boolean addEmployee(Employee employee) {
        if (employee != null) {
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
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return employees.size();
    }

    @Override
    public double totalSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.calcSalary();
        }
        return sum;
    }

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

    @Override
    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public ArrayList<Employee> findEmployeesHoursGreaterThan(int hours) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getHours() > hours) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Employee> findEmployeesSalaryRange(int minSalary, int maxSalary) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.calcSalary() >= minSalary && employee.calcSalary() < maxSalary) {
                result.add(employee);
            }
        }
        return result;
    }
}
