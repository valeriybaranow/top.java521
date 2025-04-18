package homeworks.Generics2.task2;


import java.util.Random;
import java.util.Scanner;

/*
    Шаблонные классы
        Задача 1.
        Создайте шаблонный класс Array, который представляет
        собой массив, позволяющий хранить объекты заданного типа.

        Необходимо реализовать:
         ■ заполнение массива с клавиатуры;
         ■ заполнение массива случайными числами;
         ■ отображение массива;
         ■ поиск максимального значения;
         ■ поиск минимального значения;
         ■ подсчет среднеарифметического значения;
         ■ сортировка массива по возрастанию;
         ■ сортировка массива по убыванию;
         ■ поиск значения в массиве, используя бинарный поиск;
         ■ замена значения в массиве на новое значение
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Array<Integer> array = new Array<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Введите значение массива: ");
            array.add(scanner.nextInt());
        }
        System.out.println(array);


        System.out.print("Введите количество рандомных значений для добавления в массив: ");
        int count = scanner.nextInt();
        Random rn = new Random();
        for (int i = 0; i < count; i++) {
            array.add(rn.nextInt((100 - 1) + 1));
        }
        System.out.println(array);

        int findItem = 5;
        System.out.print("Поиск индекса по значению " + findItem + ": ");
        int result = array.find(findItem);
        if (result == -1) {
            System.out.println("значение не найдено");
        } else {
            System.out.println(result);
        }

        System.out.print("Максимум массива: ");
        System.out.println(array.max());

        System.out.print("Минимум массива: ");
        System.out.println(array.min());

        System.out.print("Среднее арифметическое: ");
        System.out.println(array.average());

        System.out.print("Сортировка: ");
        array.sortAsc();
        System.out.println(array);

        System.out.print("Сортировка: ");
        array.sortDesc();
        System.out.println(array);

        System.out.print("Замена значения: ");
        array.replase(100, 5);
        System.out.println(array);


        Array<String> arrayString = new Array<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Введите значение массива: ");
            arrayString.add(scanner.nextLine());
        }
        System.out.println(arrayString);


        System.out.print("Введите количество рандомных значений для добавления в массив: ");
        int countItemStr = scanner.nextInt();
        Scanner s = new Scanner(new RandomWords(countItemStr));
        while(s.hasNext()) {
            arrayString.add(s.next());
        }
        System.out.println(arrayString);

        String findString = "test";
        System.out.print("Поиск индекса по значению " + findString + ": ");
        int resultFindStr = arrayString.find(findString);
        if (resultFindStr == -1) {
            System.out.println("значение не найдено");
        } else {
            System.out.println(resultFindStr);
        }

        System.out.print("Максимум массива: ");
        System.out.println(arrayString.max());

        System.out.print("Минимум массива: ");
        System.out.println(arrayString.min());

        System.out.print("Среднее арифметическое: ");
        System.out.println(arrayString.average());

        System.out.print("Сортировка: ");
        arrayString.sortAsc();
        System.out.println(arrayString);

        System.out.print("Сортировка: ");
        arrayString.sortDesc();
        System.out.println(arrayString);

        System.out.print("Замена значения: ");
        arrayString.replase("replace", 5);
        System.out.println(arrayString);
    }
}

