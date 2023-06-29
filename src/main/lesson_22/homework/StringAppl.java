package main.lesson_22.homework;

public class StringAppl {
    public static void main(String[] args) {
        String str = "Hello";
        char[] chars = {32, 'w', 'o', 'r', 'l', 'd'};
        String str1 = new String(chars);
        System.out.println(str1);
        str = str + str1;               // str = str.concat(str1)
        System.out.println(str);
        System.out.println(str.length());
        char c = str.charAt(str.length() - 1);
        System.out.println(c);
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
        String str2 = " World";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        String str3 = str.toUpperCase();
        System.out.println(str3);
        System.out.println(str);
        str3 = str3.toLowerCase();
        System.out.println(str3);
        int index = str.indexOf('l');
        System.out.println(index);
        index = str.indexOf("or");
        System.out.println(index);
        index = str.indexOf('l', 3);
        System.out.println(index);
        index = str.lastIndexOf('l');
        System.out.println(index);
        System.out.println(str.substring(2, 6));
        System.out.println(str.replace("o", "o-o-o"));
        String str4 = "    John  ";
        System.out.println(str4.trim());
        System.out.println("====== split ======");
        String text = "I'm a software ingeneer";
        String[] arr = text.split(" ");  // каждое слово разделяет после пробела
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
