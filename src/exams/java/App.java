package exams.java;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

/*
    Третий вариант. Создать приложение «Коллекция текстовых документов».

    Проект должен позволять выполнять базовые операции с текстовыми документами.
    Интерфейс приложения должен позволять выводить результат работы приложения в консоль или файл.
    Приложение должно поддерживать интерфейс командной строки.
    1. Открытие документа (если содержимое документа не помещается на одном экране, нужно организовать постраничный вывод
     с возможностью перехода вперед или назад на одну страницу),
    2. Поиск по документу (пользователь вводит слово для поиска, после чего производится поиск, вывод результатов должен
    быть осуществлен с возможностью перехода на следующее или предыдущее место, где найдено искомое слово/комбинация слов),
    3. Замена слова или комбинации слов в документе,
    4. Создание нового документа.
    5. При старте проекта отображается структура коллекции.
    6. Пользователь может задать корневую папку коллекции.
    7. Просмотр свойств документа (размер, автор, дата создания).
    8. Сортировка коллекции документов (по размеру, автору, дате создания).
 */
public class App {
    private static String pathDir = ".";
    private static String fileName;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        FileManager fileManager = FileManager.instance("Коллекция текстовых документов");
        fileManager.cnangeDir(pathDir);

        fileManager.start(menuItems -> {
            switch (menuItems[0]) {
                case 0 -> {
                    System.out.print("выберите папку: ");
                    pathDir = scanner.nextLine().trim();
                    fileManager.cnangeDir(pathDir);
                }
                case 1 -> {
                    switch (menuItems[1]) {
                        case -1 -> {
                            System.out.print("выберите файл: ");
                            fileName = scanner.nextLine().trim();
                            if (fileManager.checkCurrentPath(fileName, FileManager.getCurrentPath())) {
                                if (Files.isDirectory(FileManager.getCurrentPath().resolve(fileName).normalize())) {
                                    System.err.println("Ошибка: указанный путь является директорией, а не файлом");
                                    break;
                                }
                                fileManager.checkAndShowFile(fileName);
                                fileManager.setMenuItemsLevelTwo(0);
                            }
                        }
                        case 0 -> {
                            fileManager.showFileNext(fileName);
                        }
                        case 1 -> {
                            fileManager.showFilePrev(fileName);
                        }
                        case 2 -> {
                            FileManager.setPrevCurrentPath();

                            fileManager.resetFileCurrenLine();
                            fileManager.showDir();
                            fileManager.setMenuItemsLevelTwo(-1);
                        }
                        default -> FileManager.printError("Неизвестная команда.");
                    }
                }
                case 2 -> {
                    switch (menuItems[1]) {
                        case -1 -> {
                            System.out.print("выберите файл: ");
                            fileName = scanner.nextLine().trim();
                            System.out.print("введите слово для поиска: ");
                            String word = scanner.nextLine().trim();
                            fileManager.findWordInFile(fileName, word);
                            fileManager.setMenuItemsLevelTwo(0);
                        }
                        case 0 -> {
                            FileManager.setPrevCurrentPath();

                            fileManager.resetFileCurrenLine();
                            fileManager.showDir();
                            fileManager.setMenuItemsLevelTwo(-1);
                        }
                        default -> FileManager.printError("Неизвестная команда.");
                    }
                }
                case 3 -> {
                    switch (menuItems[1]) {
                        case -1 -> {
                            System.out.print("выберите файл: ");
                            fileName = scanner.nextLine().trim();
                            System.out.print("введите слово для поиска: ");
                            String oldWord = scanner.nextLine().trim();
                            System.out.print("введите слово для замены: ");
                            String newWord = scanner.nextLine().trim();
                            fileManager.replaceWordInFile(fileName, oldWord, newWord);
                            fileManager.setMenuItemsLevelTwo(0);
                        }
                        case 0 -> {
                            FileManager.setPrevCurrentPath();

                            fileManager.resetFileCurrenLine();
                            fileManager.showDir();
                            fileManager.setMenuItemsLevelTwo(-1);
                        }
                        default -> FileManager.printError("Неизвестная команда.");
                    }
                }
                case 4 -> {
                    System.out.print("Введите имя файла: ");
                    fileName = scanner.nextLine().trim();

                    fileManager.createFile(fileName);
                    fileManager.refreshDir();
                    FileManager.printMessage("Файл успешно создан: " + fileName);
                }
                case 5 -> {
                    System.out.println("Введите номер колонки для сортировки: ");
                    Arrays.stream(FileManager.MenuColumnItems.values()).forEach(item -> item.displayIfAllowed());
                    System.out.println();
                    String colNumber = scanner.nextLine().trim();
                    fileManager.sortFileInDir(Integer.parseInt(colNumber));
                    fileManager.showDir();
                }
                default -> FileManager.printError("Неизвестная команда.");
            }
        });
    }
}
