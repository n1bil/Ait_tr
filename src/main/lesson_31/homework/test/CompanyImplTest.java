package main.lesson_31.homework.test;

import main.lesson_31.homework.model.Employee;
import main.lesson_31.homework.model.Engineer;
import main.lesson_31.homework.model.Worker;
import main.lesson_31.homework.service.Company;
import main.lesson_31.homework.service.CompanyImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CompanyImplTest {

    Company company;
    Employee[] employees;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl(4);
        employees = new Employee[]{
                new Engineer("Steve Jobs", 1963, 12, false, 15, 160),
                new Worker("Mark Zuckerberg", 1978, 8, true, 11, 150),
                new Engineer("Bill Gates", 1960, 14, false, 13, 120)
        };
        for (int i = 0; i < employees.length; i++) {
            company.hireEmployee(employees[i]);
        }
    }

    @Test
    void hireEmployee() {
        assertFalse(company.hireEmployee(null));
        assertFalse(company.hireEmployee(employees[2]));
        assertTrue(company.hireEmployee(new Worker("Pavel Durov", 1985, 9, true, 12, 150)));
        assertFalse(company.hireEmployee(new Worker("Sergei Brin", 1974, 10, true, 10, 160)));
        company.quantity();
    }

    @Test
    void fireEmployee() {
        assertEquals(employees[0] ,company.fireEmployee("Steve Jobs"));
        assertEquals(2, company.quantity());
        assertNull(company.fireEmployee("Steve Jobs"));
    }

    @Test
    void findEmployee() {
        assertEquals(employees[1], company.findEmployee("Mark Zuckerberg"));
        assertNull(company.findEmployee("Pavel Durov"));
    }

    @Test
    void quantity() {
        assertEquals(3, company.quantity());
    }

    @Test
    void findEmployeesByWorkExperience() {
        Employee[] expected = company.findEmployeesByWorkExperience(10);
        Employee[] actual = new Employee[]{employees[0], employees[2]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findEmployeesBySalary() {
        Employee[] expected = company.findEmployeesBySalary(2000);
        Employee[] actual = new Employee[]{employees[0]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findEmployeesByHigherEducation() {
        Employee[] expected = company.findEmployeesByHigherEducation(true);
        Employee[] actual = new Employee[]{employees[1]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void printEmployeesByAge() {
        Arrays.sort(employees, (emp1, emp2) ->
            emp1.getYearOfBirth() - emp2.getYearOfBirth()
        );
        printEmployee();
    }

    @Test
    void printEmployeesByWorkExperience() {
        Arrays.sort(employees, (emp1, emp2) ->
            emp1.getWorkExperience() - emp2.getWorkExperience()
        );
        printEmployee();
    }

    @Test
    void printEmployeesBySalary() {
        Arrays.sort(employees, (emp1, emp2) ->
            emp1.payroll() - emp2.payroll()
        );
        printEmployee();
    }

    @Test
    void printEmployeesByHigherEducation() {
        Arrays.sort(employees, (emp1, emp2) ->
                Boolean.compare(emp2.isHasHigherEducation(), emp1.isHasHigherEducation())
        );
        printEmployee();
    }

    @Test
    void printEmployee() {
        System.out.println("======= Print Employees =======");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }
}