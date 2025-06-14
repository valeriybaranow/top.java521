package homeworks.Stream.task4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/*
    Сортировка и поиск:
    - Создайте список целых чисел.
    - Отсортируйте его по убыванию.
    - Найдите первые 3 элемента после сортировки.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,6);

       System.out.println(list);

        List<Integer> changedList = list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3).toList();

        System.out.println("Список после преобразования");
        System.out.println(changedList);
    }
}
