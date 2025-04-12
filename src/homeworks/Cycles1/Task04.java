package homeworks.Cycles1;

import java.util.Scanner;

// TODO: Факториал числа.

/**
 * Напишите программу, которая выводит таблицу умножения для числа, введенного пользователем.
 *
 * Тест ввода:
 * Введите число: 7
 * Ожидаемый вывод:
 * Таблица умножения для числа 7:
 * 7 x 1 = 7
 * 7 x 2 = 14
 * 7 x 3 = 21
 * 7 x 4 = 28
 * 7 x 5 = 35
 * 7 x 6 = 42
 * 7 x 7 = 49
 * 7 x 8 = 56
 * 7 x 9 = 63
 * 7 x 10 = 70
 */
public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "y";
        int number;
        do {
            System.out.print("Введите число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("Ошибка!!! Вы ввели некорректные данные.");
                continue;
            }

            System.out.printf("Таблица умножения для числа %d:\n", number);
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%d\tx\t%d\t=\t%d\n", number, i, number * i);
            }
            System.out.println("---------------------------------------------");
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%d x %d = %d\n", number, i, number * i);
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
