package homeworks.HashSet.task5;

import java.util.Set;
import java.util.TreeSet;

/**
 * Задача 5: Сортировка товаров по цене и рейтингу TreeSet.
 * Создайте класс Product с полями name, price (double) и rating (int). Отсортируйте товары:
 * Сначала по цене (от дешевых к дорогим).
 * Если цена одинаковая – по рейтингу (от высокого к низкому).
 */
public class Main {
    public static void main(String[] args) {
        Set<Product> products = new TreeSet<>();
        products.add(new Product("Колбаса", 100, 1));
        products.add(new Product("Сыр", 200, 1));
        products.add(new Product("Масло", 300, 2));
        products.add(new Product("Хлеб", 300, 1));
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
