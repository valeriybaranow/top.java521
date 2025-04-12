package homeworks.Cycles1;

import java.util.Scanner;

// TODO: Факториал числа.

/**
 * Напишите программу, которая выводит числа от N до 1 в обратном порядке.
 *
 * Тест ввода:
 * Введите N: 3
 * Ожидаемый вывод:
 * 3
 * 2
 * 1
 */
public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "y";
        int number;
        do {
            System.out.print("Введите №: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number < 1) {
                    scanner.nextLine();
                    System.out.println("Введенное число не можте быть меньше 1.");
                    continue;
                }
            } else {
                scanner.nextLine();
                System.out.println("Ошибка!!! Вы ввели некорректные данные.");
                continue;
            }

            for (int i = number; i >= 1; i--) {
                System.out.println(i);
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
}
