package main.lesson_12.classwork;

public class StringCharExample {
    public static void main(String[] args) {
        char c = 65;
        System.out.println(c);
        char b = 'a';
        System.out.println(b);
        int x = 'C' - 'A';
        System.out.println(x);
        x = b - c;
        System.out.println(x);
        x = 'f';
        System.out.println(x);
        for (char i = 'A'; i < 'Z'; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("=========== String ===========");
        String str = "Hello";
        System.out.println(str);
        str = str + " world";       // concatenation
        System.out.println(str);
        str = str + 8;
        System.out.println(str);
        greeting("Peter");
        greeting("John");
    }

    public static void greeting(String name) {
        String str = "Welcome " + name + "!";
        System.out.println(str);
    }
}
