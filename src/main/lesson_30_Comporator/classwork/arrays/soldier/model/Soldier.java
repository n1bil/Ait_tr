package main.lesson_30_Comporator.classwork.arrays.soldier.model;

public class Soldier implements Comparable<Soldier> {
    String name;
    int height;
    double weight;
    int profile;

    public Soldier(String name, int height, double weight, int profile) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.profile = profile;
    }

    @Override
    public int compareTo(Soldier o) {
        int result = this.height - o.height;
        return result != 0 ? result : -(this.profile - o.profile);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", profile=" + profile +
                '}';
    }

}
