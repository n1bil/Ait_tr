package main.lesson_60_MultithreadingIntro.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TarakansRace {
    public static void main(String[] args) {

        startGame();
    }

    private static void startGame() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the distance: ");
        int distance = 0;
        try {
            distance = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Tarakan[] tarakans = new Tarakan[4];
        for (int i = 0; i < tarakans.length; i++) {
            System.out.print("Enter the name of the " + (i + 1) + " tarakan: ");
            String name = null;
            try {
                name = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            tarakans[i] = new Tarakan(name, distance);
        }
        Thread[] threads = new Thread[tarakans.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tarakans[i]);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
