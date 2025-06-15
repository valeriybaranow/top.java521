package homeworks.files.taskfive;

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
        Год рождения.
    2. Просмотр ранее сохраненных контактов с возможностью просмотра всех данных контакта.
    3. Поиск контакта по номеру телефона или имени.
    4. Валидация контактов:
    Проверка наличия уникальных номеров телефонов для каждого контакта;
    Проверка корректности электронных адресов.
    5. Возможность сохранения и загрузки списка контактов из файла для дальнейшего использования.
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

        CommonUtils.checkMode(args);
        List<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        ConsoleHelper.showMenu("Телефонная книга", menuItems, choice -> {
            switch (choice) {
                case 0 -> {
                    String name = "Валерий";
                    String surname = "Баранов";
                    String nickname = "valeriybaranow";
                    String email = "valeriybaranow@gmail.com.asd";

                    if (Mode.DEFAULT == CommonUtils.mode) {
                        System.out.println("Введите имя:");
                        name = scanner.nextLine();

                        System.out.println("Введите фамилию:");
                        surname = scanner.nextLine();

                        System.out.println("Введите никнейм:");
                        nickname = scanner.nextLine();

                        System.out.println("Введите email:");
                        email = scanner.nextLine();
                    }
                    try {
                        Contact contact = new Contact(name, surname, nickname, email);
                        contact.addPhone("9119122342", PhoneNumber.PhoneType.MOBILE);
                        contacts.add(contact);
                        System.out.println("Контакт добавлен");
                    } catch (IllegalPhoneException | IllegalEmailException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case 1 -> {
                    if (contacts.isEmpty()) {
                        System.out.println("Контакты отсутствуют");
                    } else {
                        contacts.forEach(System.out::println);
                    }
                }
                case 2 -> {
                    System.out.println("Введите номер телефона или имя:");
                    String nameOrPhone = scanner.nextLine().trim();
                    List<Contact> findContacts = contacts.stream().filter(contact ->
                            nameOrPhone.equalsIgnoreCase(contact.getFirstName().trim())
                                    || contact.getAllPhoneNumbers().stream().anyMatch(phone -> nameOrPhone.equals(phone.number()))
                    ).toList();
                    if (findContacts.isEmpty()) {
                        System.out.println("Контакт не найден");
                    } else {
                        findContacts.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.println("Введите путь к файлу для сохранения:");
                    String path = scanner.nextLine();
                    TextFileProcessor.saveObjects(path, contacts);
                    System.out.println("Телефонная книга сохранена в файл");
                    System.out.printf("Контакты для телефонной книги выгружены в файл %s\n", path);
                }
                case 4 -> {
                    System.out.println("Введите путь к файлу для считывания:");
                    String path = scanner.nextLine();
                    contacts.clear();
                    contacts.addAll(TextFileProcessor.readObjects(path));
                    System.out.printf("Контакты для телефонной книги загружены из файла %s\n", path);
                }
                default -> ConsoleHelper.printError("Неизвестная команда.");
            }
        });
    }
}
