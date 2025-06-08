package homeworks.files.taskthree;

import homeworks.files.CommonUtils;
import homeworks.files.ConsoleHelper;
import homeworks.files.Mode;
import homeworks.files.TextFileProcessor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Задание 3:
    1. Пользователь вводит с клавиатуры пути к четырем файлам.
    2. Программа открывает каждый из четырех файлов и считывает их содержимое.
    3. Программа записывает содержимое трех файлов в четвертый файл.
    4. Программа подсчитывает количество перенесенных байт.
    5. Программа выводит на экран отчет о количестве перенесенных байт.
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

                    List<String> filePaths = new ArrayList<>();

                    filePaths.add("data" + File.separator + "file1.txt");
                    filePaths.add("data" + File.separator + "file2.txt");
                    filePaths.add("data" + File.separator + "file3.txt");
                    filePaths.add("data" + File.separator + "file4.txt");

                    if (Mode.DEFAULT == CommonUtils.mode) {
                        System.out.println("Введите путь четырем файлам:");
                        String filePathTemp;
                        for (int i = 0; i < 3; i++) {
                            filePathTemp = scanner.nextLine().trim();
                            // Проверка существования файла
                            if (!TextFileProcessor.checkFileExists(filePathTemp)) {
                                return;
                            }
                            filePaths.add(filePathTemp);
                        }
                    }

                    try {
                        TextFileProcessor.copyFile(filePaths);
                        String formatted = String.format("Файл %s дописан файлами %s\n",
                                filePaths.get(filePaths.size() - 1),
                                filePaths.stream().limit(filePaths.size() - 1).toString()
                        );
                        ConsoleHelper.printMessage(formatted);
                    } catch (IOException e) {
                        ConsoleHelper.printError("Ошибка копирования файлов: " + e.getMessage());
                    }
                }
                case 1 -> ConsoleHelper.printError("Функция временно недоступна.");
                default -> ConsoleHelper.printError("Неизвестная команда.");
            }
        });
    }
}
