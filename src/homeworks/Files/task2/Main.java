package homeworks.Files.task2;

import homeworks.Files.App;
import homeworks.Files.Functions;
import homeworks.Files.Mode;
import homeworks.Files.task1.TextFileProcessor;

import java.io.File;
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
        Functions.checkMode(args);
        Scanner scanner = new Scanner(System.in, "UTF-8");

        Boolean isFinished = false;
        while (!isFinished) {
            // data/statistic.txt
            String filePath = "data" + File.separator + "statistic.txt";
            String searchWord = "Текст";      // Слово для поиска
            String replacementWord = "Файл"; // Слово для замены
            String countReplaced;   // количество замен
            if (Mode.DEFAULT == Functions.mode) {
                System.out.println("Введите путь к файлу:");
                filePath = scanner.nextLine();
            }
            // Проверка существования файла
            if (!TextFileProcessor.checkFileExists(filePath)) {
                return;
            }
            if (Mode.DEFAULT == Functions.mode) {
                System.out.println("Введите слово для поиска:");
                searchWord = scanner.nextLine();

                System.out.println("Введите слово для замены:");
                replacementWord = scanner.nextLine();
            }

            int workCount = TextFileProcessor.replaceWord(filePath, searchWord, replacementWord);
            isFinished = App.showContinueMenu(isFinished);
        }
    }
}
