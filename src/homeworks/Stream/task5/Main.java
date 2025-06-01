package homeworks.Stream.task5;

import java.util.ArrayList;
import java.util.List;

/*
    Параллельная обработка:
    - Создайте список чисел от 1 до 1000.
    - Используя параллельный поток, найдите сумму квадратов всех чисел.
    - Сравните время выполнения с обычным потоком.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1_000; i++) {
            numbers.add(i);
        }

        long start = System.currentTimeMillis();
        long sum = numbers.parallelStream()
                .reduce(
                        0L,
                        (subtotal, element) -> subtotal + ((long) element * element),
                        Long::sum
                );
        System.out.println("Сумма вычисленная в параллельных потоках - " + sum);
        long end = System.currentTimeMillis();
        System.out.println("Время вычисления в параллельных потоках, мс - " + (end - start));

        start = System.currentTimeMillis();
        sum = numbers.stream()
                .reduce(
                        0L,
                        (subtotal, element) -> subtotal + ((long) element * element),
                        Long::sum
                );
        System.out.println("Сумма вычисленная в одном потоке - " + sum);
        end = System.currentTimeMillis();
        System.out.println("Время вычисления в одном потоке, мс - " + (end - start));

    }
}
