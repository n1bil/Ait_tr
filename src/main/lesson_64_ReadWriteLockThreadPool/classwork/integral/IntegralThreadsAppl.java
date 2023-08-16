package main.lesson_64_ReadWriteLockThreadPool.classwork.integral;

import main.lesson_64_ReadWriteLockThreadPool.classwork.integral.task.SumRectangles;

import java.util.Arrays;

public class IntegralThreadsAppl {
    private static final int N_TASKS = 1000;
    private static final double A = 0;
    private static final double B = 3;
    private static final int N_PARTS = 100_0000;

    public static void main(String[] args) throws InterruptedException {
        SumRectangles[] tasks = new SumRectangles[N_TASKS];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new SumRectangles(A, B, x -> x * x, N_PARTS, N_TASKS, i);
        }
        Thread[] threads = new Thread[tasks.length];
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Duration = " + (t2 - t1));
        double res = Arrays.stream(tasks)
                .mapToDouble(SumRectangles::getResult)
                .sum();
        System.out.println("Result = " + res);
    }
}