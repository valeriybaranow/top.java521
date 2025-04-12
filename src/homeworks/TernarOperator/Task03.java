package homeworks.TernarOperator;

import java.util.Scanner;

public class Task03 {

    // TODO: Напишите программу, которая проверяет, делится ли введенное пользователем число нацело на 2 и 5 или на 3 и 7.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer number;
        String manager = "y";
        do {
            System.out.println("Неоходимо проверить возможность делелния введенного числа нацело на 2 и 5 или на 3 и 7");
            System.out.print("Введите число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // Чистим буфер
            } else {
                System.out.println("Ошибка! Вы ввели некорректные данные.");
                scanner.nextLine(); // Чистим буфер
                continue;
            }
            boolean condition1 = number % 2 == 0 && number % 5 == 0;
            boolean condition2 = number % 3 == 0 && number % 7 == 0;
            if (condition1 || condition2) {
                if (condition1) {
                    System.out.println("Число " + number + " делится на 2 и 5.");
                }

                if (condition2) {
                    System.out.println("Число " + number + " делится на 3 и 7.");
                }
            } else {
                System.out.println("Не выполнено не одно условие для числа " + number + ".");
            }
            System.out.print("Вы хотите продолжить y\\n: ");
            manager = scanner.nextLine();
            while (!(manager.equals("y") || manager.equals("n"))) {
                System.out.print("Можно вводить только значения y\\n. ");
                System.out.print("Вы хотите продолжить y\\n: ");
                manager = scanner.nextLine();
            }
        }
        while (manager.equals("y"));
        System.out.println("Выход из программы");
        scanner.close();
    }
}

