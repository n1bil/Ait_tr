package main.lesson_31.classwork.model;

public class Cat implements Comparable<Cat>{
    // create class, 4-5 fields
    // standard constructor, getters and setters
    // toString - override
    // create class for testing
    // create array with ...
    // добавить comparable in class Cat, override method
    // compareTo and sort array cats

    String name;
    int weight;
    String color;
    int age;

    public Cat(String name, int weight, String color, int age) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.age = age;
    }



    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Cat o) {       // return int: +1 || -1 || 0
        int res = this.age - o.age;
        return res;

//        if (res > 0) {
//            return 1;
//        }else if (res == 0) {
//            return 0;
//        }else {
//            return -1;
//        }
    }


    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }
}
