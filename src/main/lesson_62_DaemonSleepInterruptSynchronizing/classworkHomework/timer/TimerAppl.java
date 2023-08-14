package main.lesson_62_DaemonSleepInterruptSynchronizing.classworkHomework.timer;

import main.lesson_62_DaemonSleepInterruptSynchronizing.classworkHomework.timer.task.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimerAppl {
    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
//        thread.setDaemon(true);             //устанавливаем thread(timer) - daemon. Timer останавливается если главный thread останавливается. Обязательно до старта назначить
        thread.start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter time interval or press q for exit");
            String str = bufferedReader.readLine();
            if (str.equalsIgnoreCase("q")) {
//                thread.stop();
                thread.interrupt();
                break;
            } else {
                timer.setClockPeriod(Integer.parseInt(str));
            }
        }
        System.out.println("Main thread stopped");
    }
}
