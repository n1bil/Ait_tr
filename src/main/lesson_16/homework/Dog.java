package main.lesson_16.homework;

public class Dog extends Pet {

    private String name;
    private String breed; // poroda
    private int age;

    public Dog(String type, double weight, String accommodations, String name, String breed, int age) {
        super(type, weight, accommodations);
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public void eat() {
        System.out.println("The dog is eating");
    }

    public void run() {
        System.out.println("The dog is running");
    }

    public void voice() {
        System.out.println("Bow-wow!");
    }

    public void sleep() {
        System.out.println("The cat is going to sleep");
    }
}
