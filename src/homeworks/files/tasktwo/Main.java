package homeworks.files.tasktwo;

import homeworks.files.ConsoleHelper;
import homeworks.files.TextFileProcessor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
    Задание 2:
    1. Пользователь с клавиатуры вводит путь к файлу, искомое слово и слово для замены.
    2. Программа открывает файл и ищет искомое слово в его содержимом.
    3. Если слово найдено, программа заменяет его на указанное слово.
    4. Программа подсчитывает количество произведенных замен.
    5. Программа выводит на экран отчет о количестве замен.
 */
public class Main {
    public static void main(String[] args) {
        String[] menuItems = {
                "Введите путь к файлу",
                "Что то еще",
                "Выход"
        };

        ConsoleHelper.showMenu("Замена слова в файле", menuItems, choice -> {
            switch (choice) {
                case 0 -> {
                    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

                    // data/statistic.txt
                    // Файл
                    System.out.println("Введите путь к файлу:");
                    String filePath = scanner.nextLine().trim();
                    // Проверка существования файла
                    if (!TextFileProcessor.checkFileExists(filePath)) {
                        return;
                    }

                    System.out.println("Введите слово для поиска:");
                    String searchWord = scanner.nextLine();

                    System.out.println("Введите слово для замены:");
                    String replacementWord = scanner.nextLine();

                    try {
                        int count = TextFileProcessor.replaceWord(filePath, searchWord, replacementWord);
                        String formatted = String.format("В файле %s выполнено %d %s%n", filePath, count, count == 1 ? "замена" : (count >= 2 && count <= 4) ? "замены" : "замен");
                        ConsoleHelper.printMessage(formatted);
                    } catch (IOException e) {
                        ConsoleHelper.printError("Ошибка чтения файла: " + e.getMessage());
                    }
                }
                case 1 -> ConsoleHelper.printError("Функция временно недоступна.");
                default -> ConsoleHelper.printError("Неизвестная команда.");
            }
        });
    }
}
