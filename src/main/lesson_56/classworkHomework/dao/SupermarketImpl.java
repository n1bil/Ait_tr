package main.lesson_56.classworkHomework.dao;

import main.lesson_56.classworkHomework.model.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SupermarketImpl implements Supermarket {

    private Map<Long, Product> products;

    public SupermarketImpl() {
        products = new HashMap<>();
    }

    @Override
    public boolean addProduct(Product product) {
        if (product != null) {
            return products.putIfAbsent(product.getBarCode(), product) == null;
        }
        return false;
    }

    @Override
    public Product removeProduct(long barCode) {
        return products.remove(barCode);
    }

    @Override
    public Product findByBarCode(long barCode) {
        return products.get(barCode);
    }

    @Override
    public Iterable<Product> findByCategory(String category) {
        return findByPredicate(product -> product.getCategory().equals(category));
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        return findByPredicate(product -> product.getBrand().equals(brand));
    }

    @Override
    public Iterable<Product> findProductsWithExpiredDate() {
        return findByPredicate(product -> product.getLocalDate().isBefore(LocalDate.now().minusDays(7))); // if the product greater 7 days
    }                                                                                                     // then this product is expired

    @Override
    public int skuQuantity() {
        return products.size();
    }

    @Override
    public Iterator<Product> iterator() {
        Collection<Product> value = products.values();
        return value.iterator();
    }

    private Iterable<Product> findByPredicate(Predicate<Product> predicate) {
        return products.values().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
