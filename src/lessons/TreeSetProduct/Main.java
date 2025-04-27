package lessons.TreeSetProduct;

import java.util.Comparator;
import java.util.TreeSet;

/*
    Создайте класс Product с полями name, price (double) и rating (int). Отсортируйте товары:
    Сначала по цене (от дешевых к дорогим).
    Если цена одинаковая – по рейтингу (от высокого к низкому).
 */
public class Main {
    public static void main(String[] args) {
        Comparator<Product> comparator = Comparator
                .comparingDouble((Product s) -> s.getPrice())
                .thenComparingInt(s -> -s.getRating());

        TreeSet<Product> products = new TreeSet<>(comparator);
        products.add(new Product("P1", 100, 1));
        products.add(new Product("P2", 200, 2));
        products.add(new Product("P3", 200, 3));
        products.add(new Product("P4", 400, 4));
        products.add(new Product("P5", 500, 5));

        for (Product item : products) {
            System.out.println(item);
        }
    }
}
