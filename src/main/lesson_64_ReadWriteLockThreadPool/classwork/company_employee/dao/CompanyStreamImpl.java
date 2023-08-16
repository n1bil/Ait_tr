package main.lesson_64_ReadWriteLockThreadPool.classwork.company_employee.dao;

import main.lesson_64_ReadWriteLockThreadPool.classwork.company_employee.model.Employee;
import main.lesson_64_ReadWriteLockThreadPool.classwork.company_employee.model.SalesManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CompanyStreamImpl implements Company {
    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    Lock rLock = rwLock.readLock();
    Lock wLock = rwLock.writeLock();
    Map<Integer, Employee> employees;
    int capacity;

    public CompanyStreamImpl(int capacity) {
        employees = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        wLock.lock();
        try {
            if (employee != null && employees.size() != capacity && findEmployee(employee.getId()) == null) {
                return employees.putIfAbsent(employee.getId(), employee) == null;
            }
            return false;
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public Employee removeEmployee(int id) {
        wLock.lock();
        try {
            Employee victim = findEmployee(id);
            if (victim != null) {
                employees.remove(id);
                return victim;
            }
            return null;
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public Employee findEmployee(int id) {
        rLock.lock();
        try {
            return employees.get(id);
        } finally {
            rLock.unlock();
        }
    }


    @Override
    public double totalSalary() {
        rLock.lock();
        try {
            return employees.values().stream()
                    .reduce(0.0, (aDouble, employee) -> aDouble + employee.calcSalary(), Double::sum);
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public double totalSales() {
        rLock.lock();
        try {
            return employees.values().stream()
                    .filter(employee -> employee instanceof SalesManager)
                    .map(employee -> (SalesManager) employee)
                    .reduce(0.0, (aDouble, salesManager) -> aDouble + salesManager.getSalesValue(), Double::sum);
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public int quantity() {
        rLock.lock();
        try {
            return employees.size();
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public void printEmployees() {
        rLock.lock();
        try {
            employees.values().forEach(System.out::println);
        } finally {
            rLock.unlock();
        }
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
        rLock.lock();
        try {
            return employees.values().stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
        } finally {
            rLock.unlock();
        }
    }
}
