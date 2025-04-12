package homeworks.Cycles1;

import java.util.Scanner;

// TODO: Факториал числа.

/**
 * Напишите программу, которая определяет сезон года на основе месяца, введенного пользователем.
 *
 * Тест ввода:
 * Введите номер месяца: 7
 * Ожидаемый вывод:
 * Июль находится в летнем сезоне.
 */
public class Task06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "y";
        int number;
        String[] monthNames = { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" };
        do {
            System.out.print("Введите число число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("Ошибка!!! Вы ввели некорректные данные.");
                continue;
            }

            switch (number) {
                case 1:
                case 2:
                case 12:
                    System.out.printf("%s находится в зимнем сезоне.\n", monthNames[number-1] + "");
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.printf("%s находится в весеннем сезоне.\n", monthNames[number-1] + "");
                    break;
                case 6:
                case 7:
                case 8:
                    System.out.printf("%s находится в летнем сезоне.\n", monthNames[number-1] + "");
                    break;
                case 9:
                case 10:
                case 11:
                    System.out.printf("%s находится в осеннем сезоне.\n", monthNames[number-1] + "");
                    break;
                default:
                    scanner.nextLine();
                    System.out.println("Необходимо ввести число от 1 до 12.");
                    continue;
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
