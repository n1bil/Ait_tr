package main.lesson_60_MultithreadingIntro.homework;

import java.util.Random;

public class Tarakan implements Runnable {

    private static Random random = new Random();
    private static boolean raceFinished = false;
    private static String winner = null;

    String name;
    int distance;

    public Tarakan(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public void run() {
        System.out.println(name + " started");
        for (int i = 1; i <= distance; i++) {
            System.out.println(name + " distance: " + i);
            try {
                Thread.sleep(random.nextInt(5 - 2 + 1) + 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == distance) {
                setWinner(name);
            }
        }
    }

    private synchronized void setWinner(String tarakanName) {
        if (!raceFinished) {
            raceFinished = true;
            winner = tarakanName;
            System.err.println("Congratulations to the winner " + winner);
        }
    }
}
