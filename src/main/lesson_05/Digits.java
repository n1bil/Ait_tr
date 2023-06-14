package main.lesson5;

public class Digits {
    public static void main(String[] args) {
        int edinica = solution(365);
        int desyatoc = solution(365);
        int tusa4naya = solution(365);
        System.out.println(desyatoc);

    }

    public static int solution(int number) {
        int result = number % 10;
        result = number / 10 % 10;
        result = number / 100;
        return result;
    }
}
