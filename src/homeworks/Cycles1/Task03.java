package homeworks.Cycles1;

import java.util.Scanner;

// TODO: Факториал числа.

/**
 * Напишите программу, которая вычисляет факториал числа, введенного пользователем.
 *
 * Тест ввода:
 * Введите число: 5
 * Ожидаемый вывод:
 * Факториал числа 5 равен 120.
 */
public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "y";
        int number;
        do {
            System.out.print("Введите число число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("Ошибка!!! Вы ввели некорректные данные.");
                continue;
            }

            long factorial = 1;

            if (number == 0) {
                factorial = 0;
            } else {
                for (int i = 1; i <= number; i++) {
                    factorial *= i;
                }
            }

            // TODO: проверка не срабатывает - нужно рахобраться почему
            if (factorial > Long.MAX_VALUE) {
                System.out.printf("Результать вычисления превышает максимально допустимое значение равен %d.\n", Long.MAX_VALUE);
            } else {
                System.out.printf("Факториал числа %d равен %d.\n", number, factorial);
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
