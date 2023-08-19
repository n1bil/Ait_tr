package main.lesson_66.todo;

import main.lesson_66.todo.dao.ToDoListImpl;
import main.lesson_66.todo.model.Menu;
import main.lesson_66.todo.model.Task;

import java.util.Scanner;

public class ToDoAppl {
    public static void main(String[] args) {
        System.out.println("Welcome to ToDoList Application");
        ToDoListImpl toDoList = new ToDoListImpl(20);

        toDoList.readTasks();

        while (true) {
            Menu.printMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Tasks:");
                    toDoList.printTasks();
                    break;
                }
                case 2: {
                    scanner.nextLine();
                    System.out.println("Input task: ");
                    String task = scanner.nextLine();
                    Task newTask = new Task(task);
                    toDoList.addTask(newTask);
                    toDoList.saveTasks();
                    break;
                }
                case 3: {
                    System.out.println("Input task ID: ");
                    int id = scanner.nextInt();
                    Task findedTask = toDoList.findTask(id);
                    System.out.println(findedTask);
                    break;
                }
                case 4: {
                    System.out.println("Input task ID: ");
                    int id = scanner.nextInt();
                    Task removedTask = toDoList.removeTask(id);
                    System.out.println(removedTask + " is removed");
                    toDoList.saveTasks();
                    break;
                }
                case 5: return;
                default: {
                    System.out.println("Wrong input");
                }
            }
        }
    }
}
