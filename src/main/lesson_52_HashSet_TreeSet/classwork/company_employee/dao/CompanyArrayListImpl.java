package main.lesson_52_HashSet_TreeSet.classwork.company_employee.dao;

import main.lesson_52_HashSet_TreeSet.classwork.company_employee.model.Employee;
import main.lesson_52_HashSet_TreeSet.classwork.company_employee.model.SalesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CompanyArrayListImpl implements Company {
    List<Employee> employees;
    int capacity;

    public CompanyArrayListImpl(int capacity) {
        employees = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || employees.size() == capacity || findEmployee(employee.getId()) != null) {
            return false;
        }
        employees.add(employee);
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {
        Employee victim = findEmployee(id);
        if  (victim != null) {
            employees.remove(victim);
            return victim;
        }
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        for (Employee employee: employees) {
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;
    }

    @Override
    public double totalSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum = sum + employee.calcSalary();
        }
        return sum;
    }

    @Override
    public double totalSales() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee instanceof SalesManager) {
                SalesManager sm = (SalesManager) employee;
                sum += sm.getSalesValue();
            }
        }
        return sum;
    }

    @Override
    public int quantity() {
        return employees.size();
    }

    @Override
    public void printEmployees() {
        for ( Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public ArrayList<Employee> findEmployeesHoursGreaterThan(int hours) {
        return findEmployeesByPredicate(employee -> employee.getHours() > hours);
    }

    @Override
    public ArrayList<Employee> findEmployeesSalaryRange(int minSalary, int maxSalary) {
        return findEmployeesByPredicate(employee -> employee.calcSalary() >= minSalary && employee.calcSalary() < maxSalary);
    }

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
