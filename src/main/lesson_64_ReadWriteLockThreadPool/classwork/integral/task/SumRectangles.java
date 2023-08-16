package main.lesson_64_ReadWriteLockThreadPool.classwork.integral.task;

import java.util.function.Function;

public class SumRectangles implements Runnable {

    double a;
    double b;
    Function<Double, Double> function;
    int nParts;
    int nTasks;
    int id;
    double delta;
    double result;

    public SumRectangles(double a, double b, Function<Double, Double> function, int nParts, int nTasks, int id) {
        this.a = a;
        this.b = b;
        this.function = function;
        this.nParts = nParts;
        this.nTasks = nTasks;
        this.id = id;
        delta = (b - a) / nParts;
    }

    public double getResult() {
        return result;
    }

    @Override
    public void run() {
        for (int i = id; i < nParts; i += nTasks) {
            double left = a + i * delta;
            double right = left + delta;
            double mid = (left + right) / 2;
            result += function.apply(mid) * delta;
        }
    }
}
