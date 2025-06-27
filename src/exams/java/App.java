package exams.java;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
    Третий вариант.
    Создать приложение «Коллекция текстовых документов».
    Проект должен позволять выполнять базовые операции с текстовыми документами.
    1. Открытие документа (если содержимое документа не помещается на одном экране, нужно организовать постраничный вывод
     с возможностью перехода вперед или назад на одну страницу),
    2. Поиск по документу (пользователь вводит слово для поиска, после чего производится поиск, вывод результатов должен
    быть осуществлен с возможностью перехода на следующее или предыдущее место, где найдено искомое слово/комбинация слов),
    3. Замена слова или комбинации слов в документе,
    4. Создание нового документа.
    5. При старте проекта отображается структура коллекции.
    6. Пользователь может задать корневую папку коллекции,
    7. Посмотреть свойства документа (размер, автор, дата создания), сортировать коллекцию документов (по размеру,
    автору, дате создания).
    Интерфейс приложения должен позволять выводить результат работы приложения в консоль или файл.
    Приложение должно поддерживать интерфейс командной строки.
 */
public class App {
    private static String pathDir = ".";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        FileManager fileManager = new FileManager("Файловый менеджер");
        fileManager.showDir(pathDir);
        fileManager.start(choice -> {
            switch (choice) {
                case 0 -> {
                    System.out.print("выберите папку: ");
                    pathDir = scanner.nextLine();

                    if (pathDir.startsWith("//")) {
                        pathDir = pathDir.substring(1); // Убираем один слеш
                    }

                    if (TextFileProcessor.checkFileExists(pathDir)) {
                        fileManager.showDir(pathDir);
                    } else {
                        FileManager.printError("папка " + pathDir + " не существует");
                    }
                }
                case 1 -> {
                    pathDir = "data";
                    Path pathFile = Paths.get(pathDir, "readFile.txt");

                    if (TextFileProcessor.checkFileExists(pathFile.toString())) {
                        fileManager.showFile(pathFile);
                    } else {
                        FileManager.printError("папка " + pathFile + " не существует");
                    }
                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {
                    System.out.println("Введите путь к файлу для считывания:");
                    String path = scanner.nextLine();

                    System.out.printf("Контакты для телефонной книги загружены из файла %s\n", path);
                }
                default -> FileManager.printError("Неизвестная команда.");
            }
        });
    }
}
