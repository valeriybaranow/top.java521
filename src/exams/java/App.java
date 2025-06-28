package exams.java;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
    Третий вариант. Создать приложение «Коллекция текстовых документов».

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
    private static int menuLevel = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        FileManager fileManager = FileManager.instance("Коллекция текстовых документов");
        fileManager.showDir(pathDir);

        fileManager.start(menuItem -> {
            switch (menuItem) {
                case 0 -> {
//                    System.out.print("\033[H\033[2J");
//                    System.out.flush();
                    System.out.print("выберите папку: ");
                    pathDir = scanner.nextLine();
                    fileManager.showDir(pathDir);
                }
                case 1 -> {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    String fileName = "C:\\Users\\valeriy\\IdeaProjects\\top.java521\\data\\readFile.txt";
                    fileManager.showFile(fileName);
                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                default -> FileManager.printError("Неизвестная команда.");
            }
        });
    }
}
