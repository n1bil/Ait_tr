package main.lesson_16.homework;

public class HouseAppl {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Funny", 5.1, "street", "Spike", "Bulldog", 3);
        Dog dog2 = new Dog("Angry", 3.8, "home", "Tomas", "Shepherd", 4);

        Cat cat1 = new Cat("Shy", 2.2, "home", "Jerry", "British", 6);
        Cat cat2 = new Cat("Silly", 1.8, "street", "Mick", "Siamese", 4);
        Cat cat3 = new Cat("Strong", 3.0, "home", "Mike", "Birman", 4);

        cat1.voice();
        cat2.voice();
        cat3.voice();
        cat1.eat();
        cat2.sleep();
        cat3.eat();

        dog1.voice();
        dog2.voice();
        dog1.eat();
        dog2.run();
    }
}
