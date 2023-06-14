package main.lesson_16.homework;

public class Cat extends Pet {

    private String name;
    private String breed; // poroda
    private int age;

    public Cat(String type, double weight, String accommodations, String name, String breed, int age) {
        super(type, weight, accommodations);
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public void eat() {
        System.out.println("The cat is eating");
    }

    public void voice() {
        System.out.println("Meow!");
    }

    public void sleep() {
        System.out.println("The cat is sleeping");
    }
}
