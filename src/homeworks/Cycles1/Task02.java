package homeworks.Cycles1;

import java.util.Scanner;

// TODO: Проверка четности числа.

/**
 * Напишите программу, которая проверяет, является ли введенное пользователем число четным или нечетным.
 *
 * Тест ввода:
 * Введите число: 7
 * Ожидаемый вывод:
 * Число 7 - нечетное.
 */
public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = null;
        int number;
        do {
            System.out.print("Введите число число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            } else {
                System.out.println("Ошибка! Вы ввели некорректные данные.");
                continue;
            }

            System.out.printf("Число %d %s.\n", number, number%2 == 0 ? "четное" : "нечетное");

            scanner.nextLine();
            System.out.print("Вы хотите продолжить y/n: ");
            // TODO: необходимо добавить проверку на вводимое значение - ввдол только y или n, иначе сообщение пользователь "Вы ввели некорректные данные"
            if (scanner.hasNextLine()) {
                result = scanner.nextLine();
            } else {
                System.out.println("Ошибка! Вы ввели некорректные данные.");
                continue;
            }
        }
        while (!result.equals("n"));
        System.out.println("Выход из программы");
        scanner.close();
    }
}
