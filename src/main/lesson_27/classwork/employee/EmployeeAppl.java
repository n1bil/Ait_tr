package main.lesson_25.classwork.abstract_class_method.employee;

import main.lesson_25.classwork.abstract_class_method.employee.model.Employee;
import main.lesson_25.classwork.abstract_class_method.employee.model.Manager;
import main.lesson_25.classwork.abstract_class_method.employee.model.SalesManager;
import main.lesson_25.classwork.abstract_class_method.employee.model.WageEmployee;

public class EmployeeAppl {
    public static void main(String[] args) {
        Employee[] firms = new Employee[6];
        firms[0] = new Manager(1000, "John", "Smith", 160, 5000, 5);
        firms[1] = new WageEmployee(2000, "Ann", "Smith", 160, 15);
        firms[2] = new SalesManager(3000, "Peter", "Jackson", 160, 25000, 0.1);
        firms[3] = new SalesManager(4000, "Rabindranat", "Anand", 80, 20000, 0.1);
//        firms[4] = new Employee(5000, "John", "Idiot", 160);

        printArray(firms);
        double total = totalSalary(firms);
        System.out.println("Total salary = " + total);
    }

    private static double totalSalary(Employee[] firms) {
        double sum = 0;
        for (int i = 0; i < firms.length; i++) {
            if (firms[i] != null) {
                sum += firms[i].calcSalary();
            }
        }
        return sum;
    }

    public static void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {         // если в массиве есть null, то печатай
                System.out.println(array[i]);
            }
        }
    }

}
