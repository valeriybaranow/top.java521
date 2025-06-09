package homeworks.files.five;

import homeworks.files.CommonUtils;
import homeworks.files.ConsoleHelper;
import homeworks.files.Mode;
import homeworks.files.TextFileProcessor;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Задание 5*:
    Написать программу-телефонную книгу, обладающую следующими функциями:
    1. Создание и сохранение новых контактов с информацией:
        Имя;
        Фамилия;
        Прозвище;
        Номера телефонов (домашний, рабочий, мобильный, факс);
        Электронные адреса;
    2. Просмотр ранее сохраненных контактов с возможностью просмотра всех данных контакта.
    3. Поиск контакта по номеру телефона или имени.
    4. Валидация контактов:
    Проверка наличия уникальных номеров телефонов для каждого контакта;
    Проверка корректности электронных адресов.
    5. Возможность сохранения и загрузки списка контактов из файла для дальнейшего использования.
    Год рождения.
 */
public class Main {
    public static void main(String[] args) {
        String[] menuItems = {
                "Добавить контакт",
                "Просмотр контактов",
                "Поиск контакта",
                "Сохранить контакты в файл",
                "Загрузить контакты из файла",
                "Выход"
        };

        ConsoleHelper.showMenu("Замена слова в файле", menuItems, choice -> {
            switch (choice) {
                case 0 -> {
                    CommonUtils.checkMode(args);
                    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

                    List<Contact> contacts = new ArrayList<>();
//                    // data/statistic.txt
//                    // Файл
//                    String filePath = "data/statistic.txt";


                    Contact contact = new Contact("tes", "test", "asdf", 1954);
                    contact.addPhone(new PhoneNumber(PhoneNumber.PhoneType.FAX, "123412134"));
                    contacts.add(contact);
                    contacts.add("word2");
                    contacts.add("word3");
                    contacts.add("word4");

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

//                    try {
////                        int count = TextFileProcessor.replaceWord(filePath, words);
////                        String formatted = String.format("В файле %s выполнено %d %s%n", filePath, count, count == 1 ? "замена" : (count >= 2 && count <= 4) ? "замены" : "замен");
////                        ConsoleHelper.printMessage(formatted);
//                    } catch (IOException e) {
//                        ConsoleHelper.printError("Ошибка чтения файла: " + e.getMessage());
//                    }
                }
                case 1 -> ConsoleHelper.printError("Функция временно недоступна.");
                default -> ConsoleHelper.printError("Неизвестная команда.");
            }
        });
    }
}
