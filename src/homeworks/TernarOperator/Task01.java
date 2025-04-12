package homeworks.TernarOperator;

import java.util.Scanner;

public class Task01 {
    // TODO: Напишите программу, которая проверяет, является ли введенное пользователем число четным или нечетным, с помощью тернарного оператора.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer digital;
        String manager = "y";
        do {
            System.out.print("Введите число: ");
            if (scanner.hasNextInt()) {
                digital = scanner.nextInt();
                scanner.nextLine(); // Чистим буфер
                System.out.println(digital % 2 == 0 ? "Число - четное." : "Число - нечетное.");
            } else {
                System.out.println("Ошибка! Вы ввели некорректные данные.");
                scanner.nextLine(); // Чистим буфер
                continue;
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
