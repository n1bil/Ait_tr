package main.lesson_25.classwork.stringBuilder;

public class StringPerfomanceTest {
    private static final int N_ITERATION = 100_000;
    private static final String WORD = "meow";

    public static void main(String[] args) {
        // String
        String str = "";
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < N_ITERATION; i++) {
            str = str + WORD;
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        // StringBuilder
        time1 = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < N_ITERATION; i++) {
            builder.append(WORD);
        }
        str = builder.toString();
        time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}
