package homeworks.Cecles;

import java.util.Scanner;

// TODO: Напишите программу, которая выводит все нечетные числа в диапазоне от 1 до 20. Программа должна использовать оператор continue, чтобы пропустить четные числа. Вывод чисел в строчку через пробел.

public class Task06 {
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
