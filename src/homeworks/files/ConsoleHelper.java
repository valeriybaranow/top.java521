package homeworks.files;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsoleHelper {
    public static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    public static void showMenu(String title, String[] options, Consumer<Integer> actionHandler) {
        while (true) {
            printHeader(title);
            printOptions(options);

            int choice = readInt("Выберите пункт: ", 1, options.length);

            if (choice == options.length) {
                printMessage("Выход из программы...");
                break;
            }

            actionHandler.accept(choice - 1); // Передаем индекс выбранного пункта
            showContinueMenu();
        }
    }

    // Вывод сообщения
    public static void printMessage(String message) {
        System.out.println(ConsoleColors.GREEN + "[INFO] " + message + ConsoleColors.RESET);
    }

    // Вывод ошибки
    public static void printError(String error) {
        System.out.println(ConsoleColors.RED + "[ERROR] " + error + ConsoleColors.RESET);
    }

    // Чтение числа с валидацией
    private static int readInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.printf("Ошибка! Введите число от %d до %d\n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число");
            }
        }
    }

    private static void printHeader(String title) {
        System.out.println("\n=== " + title + " ===");
    }

    private static void showContinueMenu() {
        while (true) {
            System.out.print("Вы хотите продолжить? (y/n): ");
            String input = ConsoleHelper.scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                System.out.println("Продолжаем работу...");
                break;
            } else if (input.equals("n")) {
                System.out.println("Завершение программы.");
                finishApp();
            } else {
                System.out.println("Некорректный ввод. Введите 'y' или 'n'.");
            }
        }
    }

    private static void finishApp() {
        scanner.close();
        System.exit(0);
    }

    private static void printOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%2d. %s\n", i + 1, options[i]);
        }
    }

    class ConsoleColors {
        // 8-цветная палитра
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";

        // Яркие цвета
        public static final String BRIGHT_GREEN = "\u001B[92m";

        // Сброс
        public static final String RESET = "\u001B[0m";

        public static void printColored(String color, String message) {
            System.out.println(color + message + RESET);
        }
    }
}
