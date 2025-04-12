package homeworks.Cecles;

import java.util.Scanner;

// TODO: Напишите программу, которая запрашивает год и определяет, является ли он високосным, используя boolean для условия. Погуглите условие, когда год високосный, там не так все просто, как выглядит на первый взгляд.

/**
 Год является високосным, если он соответствует следующим правилам
 - Годы,
 делящиеся на 100 без остатка, не являются високосными,
 за исключением годов, которые делятся на 400 без остатка.
 Например, 1900 год не является високосным, а 2000 год — является.

 - Годы делящиеся на 4 без остатка (например, 2016, 2024), являются високосными.
 */

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "y";
        int year;
        do {
            System.out.print("Введите год: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year < 1) {
                    scanner.nextLine();
                    System.out.println("Введенный год не можте быть меньше 1.");
                    continue;
                }
            } else {
                scanner.nextLine();
                System.out.println("Ошибка!!! Вы ввели некорректные данные.");
                continue;
            }

            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

            System.out.printf("Год %d %s.\n", year, isLeapYear ? "високосный" : "не високосный");

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
