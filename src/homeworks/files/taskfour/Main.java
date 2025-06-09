package homeworks.files.taskfour;

import homeworks.files.CommonUtils;
import homeworks.files.ConsoleHelper;
import homeworks.files.Mode;
import homeworks.files.TextFileProcessor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Задание 4:
    1. Пользователь вводит с клавиатуры путь к файлу и список запрещенных слов.
    2. Программа открывает файл и считывает его содержимое.
    3. Программа проверяет каждое слово из файла на наличие среди запрещенных слов.
    4. Если слово найдено в списке запрещенных слов, программа удаляет его из файла.
    5. Программа подсчитывает количество удаленных слов и подробно отображает информацию о каждом удаленном слове.
    6. Программа выводит на экран отчет о количестве удаленных слов с детализацией по каждому слову.
 */
public class Main {
    public static void main(String[] args) {
        String[] menuItems = {
                "Введите путь к файлам",
                "Что то еще",
                "Выход"
        };

        ConsoleHelper.showMenu("Замена слова в файле", menuItems, choice -> {
            switch (choice) {
                case 0 -> {
                    CommonUtils.checkMode(args);
                    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

                    List<String> words = new ArrayList<>();
                    // data/statistic.txt
                    // Файл
                    String filePath = "data/statistic.txt";


                    words.add("word1");
                    words.add("word2");
                    words.add("word3");
                    words.add("word4");

                    if (Mode.DEFAULT == CommonUtils.mode) {
                        System.out.println("Введите путь к файлу:");
                        filePath = scanner.nextLine().trim();
                        // Проверка существования файла
                        if (!TextFileProcessor.checkFileExists(filePath)) {
                            return;
                        }

                        System.out.println("Введите запрещенные слова:");
                        for (int i = 0; i < 3; i++) {
                            words.add(scanner.nextLine().trim());
                        }
                    }

                    try {
                        int count = TextFileProcessor.replaceWord(filePath, words);
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
