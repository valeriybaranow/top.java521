package exams.java;

import homeworks.files.taskfive.IllegalEmailException;
import homeworks.files.taskfive.IllegalPhoneException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class FileManager {
    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    private static final int countLines = 2;
    private static final int currentLine = 0;
    private final String[] menuShowFolderItems = {"сменить папку", "показать файл", "поиск", "замена", "создать", "сортировать", "выход"};
    private final String[] menuShowFileItems = {"следующая страница", "предыдущая страница", "назад"};
    private String title;

    public FileManager(String title) {
        this.title = title;
    }

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

    public static String truncateStringWithEllipsis(String str, int maxLength) {
        if (str == null) {
            return null;
        }
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength - 3) + "...";
    }

    private static void finishApp() {
        scanner.close();
        System.exit(0);
    }

    private static void showContinueMenu() {
        while (true) {
            System.out.print("Вы хотите продолжить? (y/n): ");
            String input = FileManager.scanner.nextLine().trim().toLowerCase();
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

    public static void printMessage(String message) {
        System.out.println(ConsoleColors.GREEN + "[INFO] " + message + ConsoleColors.RESET);
    }

    public static void printError(String error) {
        System.out.println(ConsoleColors.RED + "[ERROR] " + error + ConsoleColors.RESET);
    }

    private static void printTitle(String title, String pathDir) {
        System.out.println("\n===================================== " + title + " ======================================");
    }

    private static void printSeparatorLine() {
        System.out.println("==============================================================================================");
    }

    public void start(Consumer<Integer> actionHandler) {
        while (true) {
            int menuItem = readInt("Выберите пункт: ", 1, menuShowFolderItems.length);

            if (menuItem == menuShowFolderItems.length) {
                printMessage("Выход из программы...");
                break;
            }

            actionHandler.accept(menuItem - 1); // Передаем индекс выбранного пункта
        }
    }

    public void showDir(String pathDir) {
        try {
            TextFileProcessor.saveStructureFolder(pathDir);
            if (TextFileProcessor.isError == false) {
                printTitle(title, pathDir);
                System.out.printf("| %-10s | %-18s | %-12s | %-19s | %-19s |%n", "Тип", "Имя", "Размер, байт", "Дата создания", "Автор");
                printSeparatorLine();
                System.out.printf("| %-90s |%n", Paths.get(pathDir).toRealPath());
                TextFileProcessor.foundFiles.forEach(foundFile -> {
                    System.out.printf(
                            "| %-10s | %-18s | %-12s | %-19s | %-19s |%n",
                            foundFile.getMode(),
                            truncateStringWithEllipsis(foundFile.getName(), 18),
                            truncateStringWithEllipsis(Long.toString(foundFile.getSize()), 12),
                            DateTimeFormatter.ofPattern("YYYY.mm.dd hh:mm:ss")
                                    .withZone(ZoneId.systemDefault())
                                    .format(foundFile.getCreationTime().toInstant()),
                            truncateStringWithEllipsis(foundFile.getAuthor(), 19)
                    );
                });
                printSeparatorLine();
            } else {
                TextFileProcessor.foundFiles.clear();
                TextFileProcessor.isError = false;
            }
            printMenu(menuShowFolderItems);
        } catch (IllegalPhoneException | IllegalEmailException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void showFile(Path pathFile) {
        try {
            List<String> content = TextFileProcessor.readFile(pathFile);
            printSeparatorLine();
            content.stream().skip(currentLine).limit(countLines).forEach(System.out::println);
            printSeparatorLine();
            printMenu(menuShowFileItems);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printMenu(String[] menuItems) {
        for (int i = 0; i < menuItems.length; i++) {
            String separator = i != (menuItems.length - 1) ? " | " : "";
            String message = String.format("%s - %d%s", menuItems[i], i + 1, separator);
            System.out.printf(ConsoleColors.GREEN + message + ConsoleColors.RESET);
        }
        System.out.println();
    }

    class ConsoleColors {
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
        public static final String BRIGHT_GREEN = "\u001B[92m";

        public static final String RESET = "\u001B[0m";

        public static void printColored(String color, String message) {
            System.out.println(color + message + RESET);
        }
    }
}
