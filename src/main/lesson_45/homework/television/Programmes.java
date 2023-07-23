package main.lesson_45.homework.television;

public class Programmes {

    private String title;

    public Programmes(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return '\'' + title + '\'';
    }
}
