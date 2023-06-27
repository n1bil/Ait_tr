package main.lesson_26.homework.task1;

public class Run {
    public static void main(String[] args) {
        Task1 task = new Task1();
        boolean hasDuplicate = task.checkDuplicate(task.randomValues());
        System.out.println("Has duplicate: " + hasDuplicate);
    }
}
