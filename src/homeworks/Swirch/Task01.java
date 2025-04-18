package homeworks.Swirch;

import java.util.Scanner;

// TODO: Напишите программу, которая принимает номер месяца от пользователя и выводит текстовое описание месяца с использованием оператора switch.
public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = null; // проверить эту строчку
        int number;
        do {
            System.out.print("Введите номер месяца (1-12) или введите exit для выхода: ");
            if (scanner.hasNextLine()) {
                result = scanner.nextLine();
                if (result.equals("exit")) {
                    continue;
                }
                try {
                    number = Integer.parseInt(result.trim());
                } catch (NumberFormatException e) { //will be thrown if number is too large
                    System.out.println("Ошибка! Вы ввели некорректные данные.");
                    continue;
                }
            } else {
                System.out.println("Ошибка! Вы ввели некорректные данные.");
                continue;
            }
            switch (number) {
                case 1:
                    System.out.println("Январь");
                    break;
                case 2:
                    System.out.println("Февраль");
                    break;
                case 3:
                    System.out.println("Март");
                    break;
                case 4:
                    System.out.println("Апрель");
                    break;
                case 5:
                    System.out.println("Май");
                    break;
                case 6:
                    System.out.println("Июнь");
                    break;
                case 7:
                    System.out.println("Июль");
                    break;
                case 8:
                    System.out.println("Август");
                    break;
                case 9:
                    System.out.println("Сентябрь");
                    break;
                case 10:
                    System.out.println("Октябрнь");
                    break;
                case 11:
                    System.out.println("Ноябрь");
                    break;
                case 12:
                    System.out.println("Декабрь");
                    break;
                default:
                    System.out.println("Ошибка! Вы ввели некорректные данные.");
                    continue;
            }
        }
        while (!result.equals("exit"));
        System.out.println("Выход из программы");
        scanner.close();
    }
}
