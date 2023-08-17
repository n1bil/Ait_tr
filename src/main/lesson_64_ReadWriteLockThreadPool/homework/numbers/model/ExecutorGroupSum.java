package main.lesson_64_ReadWriteLockThreadPool.homework.numbers.model;

import main.lesson_64_ReadWriteLockThreadPool.homework.numbers.task.OneGroupSum;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorGroupSum extends GroupSum{
    public ExecutorGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() {
        OneGroupSum[] tasks = new OneGroupSum[numberGroups.length];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new OneGroupSum(numberGroups[i]);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (OneGroupSum task : tasks) {
            executorService.execute(task);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Arrays.stream(tasks)
                .mapToInt(OneGroupSum::getSum)
                .sum();
    }
}
