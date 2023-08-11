package main.lesson_60_MultithreadingIntro.classwork.multithreading.task;

public class MyTaskExtends extends Thread {
    String name;
    int max;

    public MyTaskExtends(String taskImplements, int max) {
        this.name = taskImplements;
        this.max = max;
    }

    @Override
    public void run() {
        System.out.println(name + " task started");
        for (int i = 0; i < max; i++) {
            System.out.println("Task " + name + ", count = " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " task stopped");
    }
}
