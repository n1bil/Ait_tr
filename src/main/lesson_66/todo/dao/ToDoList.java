package main.lesson_66.todo.dao;

import main.lesson_66.todo.model.Task;

public interface ToDoList {

    boolean addTask(Task task);

    Task findTask(int id);

    Task removeTask(int id);

    void printTasks();

    int quantity();

    void readTasks();

    void saveTasks();

}
