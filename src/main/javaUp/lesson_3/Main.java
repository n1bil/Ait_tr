package main.javaUp.lesson_3;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Objects;

public class Main {

    private static final int FINISH_IN_H = 8;

    private static final String BREAK_END = "break-end.wav";
    private static final String BREAK_START = "break-start.wav";
    private static final int WORK_DURATION = 25;
    private static final int BREAK_LONG_DURATION = 30;
    private static final int BREAK_SHORT_DURATION = 5;

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = now.plusMinutes(1);

        int counter = 0;
        while (now.isBefore(localDateTime)) {
            counter++;
            alert(BREAK_END);
            System.out.println("Time to work");
            sleep(WORK_DURATION);

            alert(BREAK_START);
            System.out.println("The has been started");
            sleep(counter % 4 == 0 ? BREAK_LONG_DURATION : BREAK_SHORT_DURATION);

            alert(BREAK_END);
            System.out.println("The pause has been ended");

            now = LocalDateTime.now();
            System.out.println(now);
        }
    }

    private static void sleep(int sleepTimeInMin) {
        long sleepTimeInMs = sleepTimeInMin * 100L;
        try {
            Thread.sleep(sleepTimeInMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void alert(String fileName) {
        try {
            ClassLoader classLoader = Main.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("main/javaUp/lesson_3/sound/" + fileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(Objects.requireNonNull(inputStream)));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
