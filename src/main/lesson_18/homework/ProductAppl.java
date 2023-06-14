package main.lesson_18.homework;

public class ProductAppl {
    public static void main(String[] args) {
        Product[] products = allTheProducts();
        printNotProduct(products);
        System.out.println();
        Product foundProduct = getProductUsingBarCode(1234142131232L);
        System.out.println(foundProduct);
    }

    public static Product getProductUsingBarCode(long barCode) {    // получаю бар код и по нему вывожу данные по бар коду
        Product[] products = allTheProducts();
        Product foundProduct = null;

        for (int i = 0; i < products.length; i++) {
            if (products[i].getBarCode() == barCode) {
                foundProduct = products[i];
                break;
            }
        }
        return foundProduct;
    }

    public static void printNotProduct(Product[] array) {          // вывести только продукт так как
        for (int i = 0; i < array.length; i++) {                   // только в Product содержится не продукты
            if (!(array[i] instanceof Food)) {
                System.out.println(array[i]);
            }
        }
    }

    public static Product[] allTheProducts() {
        Product[] products = new Product[5];
        products[0] = new Product(15.34, "Globe", 32141242131L);
        products[1] = new Food(23.20, "Rice", 1234142131232L, "21.08.2023");
        products[2] = new MeatFood(44.00, "fillet", 868663524243L, "17.06.2023", "chicken");
        products[3] = new MilkFood(18.99, "kefir-prostokvashino", 6868938569434L, "19.06.2023", "kefir", 3.2);
        products[4] = new Product(15.34, "Pen", 32991742111L);

        return products;
    }
}
