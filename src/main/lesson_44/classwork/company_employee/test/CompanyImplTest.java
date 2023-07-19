package main.lesson_44.classwork.company_employee.test;

import main.lesson_44.classwork.company_employee.dao.Company;
import main.lesson_44.classwork.company_employee.dao.CompanyImpl;
import main.lesson_44.classwork.company_employee.model.Employee;
import main.lesson_44.classwork.company_employee.model.Manager;
import main.lesson_44.classwork.company_employee.model.SalesManager;
import main.lesson_44.classwork.company_employee.model.WageEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyImplTest {

    Company company;
    ArrayList<Employee> firm;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl();
        firm = new ArrayList<>();
        firm.add(new Manager(1000, "John", "Smith", 160, 5000, 5));
        firm.add(new WageEmployee(2000, "Ann", "Smith", 160, 15));
        firm.add(new SalesManager(3000, "Peter", "Jackson", 160, 25000, 0.1));
        firm.add(new SalesManager(4000, "Rabindranat", "Anand", 80, 20000, 0.1));
        for (Employee employee : firm) {
            company.addEmployee(employee);
        }
    }

    @Test
    void addEmployee() {
        assertFalse(company.addEmployee(null));
        assertTrue(company.addEmployee(firm.get(1)));
        assertEquals(5, company.quantity());
        Employee employee = new SalesManager(5000, "Rabindranat", "Anand", 80, 20000, 0.1);
        assertTrue(company.addEmployee(employee));
        employee = new SalesManager(6000, "Rabindranat", "Anand", 80, 20000, 0.1);
        assertTrue(company.addEmployee(employee));
    }

    @Test
    void removeEmployee() {
        assertEquals(firm.get(2), company.removeEmployee(3000));
        assertEquals(3, company.quantity());
        assertNull(company.removeEmployee(3000));
    }

    @Test
    void findEmployee() {
        assertEquals(firm.get(1), company.findEmployee(2000));
        assertNull(company.findEmployee(5000));
    }

    @Test
    void quantity() {
        assertEquals(4, company.quantity());
    }

    @Test
    void totalSalary() {
        assertEquals(12700, company.totalSalary(), 0.01);
    }

    @Test
    void avgSalary() {
        assertEquals(12700. / 4, company.avgSalary(), 0.01);
    }

    @Test
    void totalSales() {
        assertEquals(45000, company.totalSales());
    }

    @Test
    void printEmployees() {
        company.printEmployees();
    }

    @Test
    void findEmployeesHoursGreaterThan() {
        ArrayList<Employee> actual = company.findEmployeesHoursGreaterThan(100);
        List<Employee> expected = List.of(firm.get(0), firm.get(1), firm.get(2));
        assertIterableEquals(actual, expected);
    }

    @Test
    void findEmployeesSalaryRange() {
        ArrayList<Employee> actual = company.findEmployeesSalaryRange(2000, 2500);
        ArrayList<Employee> expected = new ArrayList<>();
        expected.add(firm.get(1));
        expected.add(firm.get(3));
        assertIterableEquals(actual, expected);
    }
}



















