package homeworks.Cecles;

import java.util.Scanner;

// TODO: Напишите программу, которая найдет и выведет все простые числа в заданном (сами задаете) диапазоне. Сделайте метод public static boolean isPrime(int num) {} и вызывайте его в методе main.

/**
 * Пример вывода:
 * Простые числа в диапазоне от 2 до 100:
 * 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
 */

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        int minValue;
        int maxValue;
        do {
            System.out.print("Введите минимальное значение диапазона: ");
            if (scanner.hasNextInt()) {
                minValue = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("Ошибка!!! Вы ввели некорректные данные.");
                continue;
            }
            System.out.print("Введите максимальное значение диапазона: ");
            if (scanner.hasNextInt()) {
                maxValue = scanner.nextInt();
                if (maxValue <= minValue) {
                    scanner.nextLine();
                    System.out.printf("Максимальное %d значение должно быть дольше минимального значения %d 1.\n", minValue, maxValue);
                    continue;
                }
            } else {
                scanner.nextLine();
                System.out.println("Ошибка!!! Вы ввели некорректные данные.");
                continue;
            }

            for (int i = minValue; i <= maxValue; i++ ) {
                if (isPrime(i)) {
                    System.out.print(i  + " ");
                }
            }

            scanner.nextLine();
            do {
                System.out.print("Вы хотите продолжить y/n: ");
                result = scanner.nextLine();
            } while (!(result.equals("y") || result.equals("n")));
        }
        while (!result.equals("n"));
        System.out.println("Выход из программы");
        scanner.close();
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
