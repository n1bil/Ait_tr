package main.lesson_66.todo.model;

import java.util.Objects;

public class Task implements Comparable<Task> {

    private int id;
    private String task;
    private static int nextId;

    public Task(String task) {
        this.id = nextId++;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return (id + 1) + ":" + task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(this.id, o.id);
    }
}
