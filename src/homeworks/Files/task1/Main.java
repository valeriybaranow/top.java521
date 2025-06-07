package homeworks.Files.task1;


import homeworks.Files.Functions;
import homeworks.Files.Mode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
    Задание 1:
    1. Пользователь вводит с клавиатуры путь к файлу.
    2. Программа считывает содержимое файла.
    3. Программа анализирует содержимое файла и подсчитывает количество букв, чисел и знаков препинания.
    4. Программа выводит на экран количество букв, чисел и знаков препинания в файле.
 */
public class Main {
    public static void main(String[] args) {
        Functions.checkMode(args);
        Scanner scanner = new Scanner(System.in, "UTF-8");

        Boolean isFinished = false;
        while (!isFinished) {
            // data/statistic.txt
            String filePath = "data" + File.separator + "statistic.txt";
            if (Mode.DEFAULT == Functions.mode) {
                System.out.println("Введите путь к файлу:");
                filePath = scanner.nextLine();
            }

            try {
                Path path = Paths.get(filePath);
                // Проверка существования файла
                if (!Files.exists(path)) {
                    System.err.println("Файл не существует: " + path.toAbsolutePath());
                    return;
                }

                String text = Files.readString(path);
                TextFileProcessor.createStatistic(text).show();

                Boolean isContinue = false;
                while (isContinue == false) {
                    System.out.print("Вы хотите продолжить? (y/n): ");
                    String input = scanner.nextLine().trim().toLowerCase();
                    if (input.equals("y")) {
                        System.out.println("Продолжаем работу...");
                        isContinue = true;
                    } else if (input.equals("n")) {
                        isContinue = true;
                        isFinished = true;
                        System.out.println("Завершение программы.");
                        scanner.close();
                        System.exit(0);
                    } else {
                        System.out.println("Некорректный ввод. Введите 'y' или 'n'.");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
