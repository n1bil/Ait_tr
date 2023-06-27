package main.lesson_25.classwork.stringBuilder;

public class StringBuilderAppl {
    public static void main(String[] args) {
        String str = "Java";
//        str = str + "_" + 11;
        str = str.concat("_");
        str = str.concat("" + 11);
        System.out.println(str);
        StringBuilder builder = new StringBuilder("Java");
        builder.append("_").append(11);
//        builder.append(11);
        builder.reverse();
        System.out.println(builder);
//        builder = "Java_11";
        str = builder.toString();
        System.out.println(str);
    }
}
