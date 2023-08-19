package main.lesson_66.todo.dao;

import main.lesson_66.todo.model.Task;

import java.io.*;

public class ToDoListImpl implements ToDoList {

    final String OUTPUT = "src/main/lesson_66/todo/File";
    final String INPUT = "src/main/lesson_66/todo/File";

    private Task[] tasks;
    private int capacity;
    private int quantity;

    public ToDoListImpl(int capacity) {
        this.tasks = new Task[capacity];
        this.capacity = capacity;
        this.quantity = 0;
    }

    @Override
    public boolean addTask(Task task) {
        if (task != null && quantity <= capacity) {
            tasks[quantity] = task;
            quantity++;
            return true;
        }
        return false;
    }

    @Override
    public Task findTask(int id) {
        for (int i = 0; i < quantity; i++) {
            if (tasks[i].getId() == id) {
                return tasks[i];
            }
        }
        return null;
    }

    @Override
    public Task removeTask(int id) {
        Task removedTask = null;
        for (int i = 0; i < quantity; i++) {
            if (tasks[i].getId() == id) {
                removedTask = tasks[i];
                for (int j = i; j < quantity - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
            }
            tasks[quantity - 1] = null;
            quantity--;
            for (int j = 0; j < quantity; j++) {
                tasks[j].setId(j);
            }
        }
        return removedTask;
    }

    @Override
    public void printTasks() {
        for (int i = 0; i < quantity; i++) {
            System.out.println(tasks[i]);
        }
        System.out.println("You have " + quantity + " tasks");
    }

    @Override
    public int quantity() {
        return quantity;
    }

    @Override
    public void readTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT))) {
            String str;
            int countTasks = 0;
            while ((str = reader.readLine()) != null) {
                int index = str.indexOf(':');
                String t = str.substring(index + 1, str.length());
                Task task = new Task(t);
                tasks[countTasks] = task;
                countTasks++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            for (int i = 0; i < quantity; i++) {
                String str = String.valueOf(tasks[i]);
                writer.write(str);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
