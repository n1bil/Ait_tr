package main.lesson_17.homework;

public class ProductAppl {
    public static void main(String[] args) {
        Product[] products = new Product[4];
        products[0] = new Product(15.34, "Globe", 32141242131L);
        products[1] = new Food(23.20, "Rice", 1234142131232L, "21.08.2023");
        products[2] = new MeatFood(44.00, "fillet", 868663524243L, "17.06.2023", "chicken");
        products[3] = new MilkFood(18.99, "kefir-prostokvashino", 6868938569434L, "19.06.2023", "kefir", 3.2);

    }

    public static void printProducts(Product[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static double sumOfAllPrices(Product[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i].getPrice();
        }
        return sum;
    }
}
