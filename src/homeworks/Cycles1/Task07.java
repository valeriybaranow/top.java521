package homeworks.Cycles1;

import java.util.Scanner;

// TODO: Факториал числа.

/**
 * Напишите программу, которая проверяет, является ли число, введенное пользователем, простым.
 *
 * Тест ввода:
 * Введите число: 13
 * Ожидаемый вывод:
 * Число 13 - простое.
 */
public class Task07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "y";
        int number;
        do {

            if (true&&false||true) {
                System.out.println("true");
            }

            System.out.print("Введите число число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("Ошибка!!! Вы ввели некорректные данные.");
                continue;
            }

            System.out.printf("Число %d - %s.\n", number, checkNumber(number) ? "простое" : "не является простым");

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

    private static boolean checkNumber(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
