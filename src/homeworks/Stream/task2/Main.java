package homeworks.Stream.task2;

import homeworks.Stream.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/*
    Трансформация данных:
    - Создайте список строк, представляющих числа в виде строк.
    - Преобразуйте этот список в список целых чисел.
    - Отфильтруйте только четные числа.
    - Преобразуйте их в строковое представление.
    - Соберите их в строку, разделенную запятыми.
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String num = String.valueOf(Generator.generateNumber(1, 1000));
            list.add(num);
        }
        System.out.println(list);

        String changedList  = list.stream()
                .map(Integer::valueOf)
                .filter(num -> num % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Строка после преобразования");
        System.out.println(changedList);
    }
}
