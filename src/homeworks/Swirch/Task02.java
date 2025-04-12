package homeworks.Swirch;

import java.util.Scanner;

// TODO: Выбор действия в зависимости от числа.

/**
 * Описание задачи:
 * Входные данные:
 *  Переменная choice содержит целое число, представляющее выбор пользователя.
 * Выходные данные:
 *  Программа определяет действие, соответствующее значению choice, и выводит его описание.
 * Алгоритм:
 * - Инициализация переменной choice с выбранным пользователем числом.
 * - Используя оператор switch, программа выбирает действие в зависимости от значения choice.
 * - Для каждого варианта case определено определенное действие.
 * - При совпадении значения choice с определенным вариантом case, программа выполняет соответствующее действие.
 * - Если choice не соответствует ни одному case, программа выполняет действие по умолчанию.
 */
public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "0";
        int choice;
        do {
            System.out.print("Введите номер действия (1-12) или введите exit для выхода: ");
            if (scanner.hasNextLine()) {
                result = scanner.nextLine();
                if (result.equals("exit")) {
                    continue;
                }
                choice = Integer.parseInt(result.trim());
            } else {
                System.out.println("Ошибка! Вы ввели некорректные данные.");
                continue;
            }
            System.out.print("Выбранное действие: ");
            switch (choice) {
                case 1:
                    System.out.println("действие 1");
                    break;
                case 2:
                    System.out.println("действие 2");
                    break;
                case 3:
                    System.out.println("действие 3");
                    break;
                case 4:
                    System.out.println("действие 4 ");
                    break;
                case 5:
                    System.out.println("действие 5 ");
                    break;
                case 6:
                    System.out.println("действие 6");
                    break;
                case 7:
                    System.out.println("действие 7");
                    break;
                case 8:
                    System.out.println("действие 8");
                    break;
                case 9:
                    System.out.println("действие 9");
                    break;
                case 10:
                    System.out.println("действие 10");
                    break;
                case 11:
                    System.out.println("действие 11");
                    break;
                case 12:
                    System.out.println("действие 12");
                    break;
                default:
                    System.out.println("действие по умолчинию");
            }
        }
        while (!result.equals("exit"));
        System.out.println("Выход из программы");
        scanner.close();
    }
}
