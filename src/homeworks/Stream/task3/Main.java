package homeworks.Stream.task3;

import homeworks.Stream.Generator;

import java.util.*;
import java.util.stream.Collectors;


/*
    Группировка и подсчет:
    - Создайте список объектов Product с полями name, category и price.
    - Используя Stream, сгруппируйте продукты по категории.
    - Для каждой категории подсчитайте количество продуктов и их суммарную стоимость
 */
public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        String[] categories = {"Electronics", "Clothing", "Food", "Books"};
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Product product = new Product(
                    "Product " + (i + 1),
                    Generator.generateNumber(10, 100), // цена от 10 до 100
                    categories[random.nextInt(categories.length)]
            );
            products.add(product);
        }
        System.out.println(products);


        Map<String, Long> productsCountCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));

        Map<String, Double> productsSumPriceCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));

        System.out.println();
        System.out.println("Статистика по категориям - вариант 1");
        System.out.println("Количество продуктов по категориям: " + productsCountCategory);
        System.out.println("Суммарная стоимость по категориям: " + productsSumPriceCategory);

        Map<String, DoubleSummaryStatistics> statsByCategory  = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.summarizingDouble(Product::getPrice)
                ));

        System.out.println();
        System.out.println("Статистика по категориям - вариант 2");
        statsByCategory.forEach((category, stats) -> {
            System.out.printf(
                    "%s: количество=%d, сумма=%.2f, средняя цена=%.2f%n",
                    category, stats.getCount(), stats.getSum(), stats.getAverage()
            );
        });
    }
}
