package homeworks.Exeption.task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*
    Задача 2. Парсинг даты:
    Напишите программу, которая запрашивает у пользователя ввод даты в формате "год-месяц-день"
    (например, "2022-01-31").
    Затем попробуйте преобразовать эту строку в объект типа LocalDate с помощью метода LocalDate.parse().
    Обработайте возможное исключение DateTimeParseException, если введенная строка имеет неверный формат.
 */
public class Main {

    static String template = "YYY-mm-dd";

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Введите дату для проверки: ");
            String date = scanner.nextLine();
            checkWord(date);
            System.out.println("Вы желаете проложить? y/n");
            int result = scanner.nextLine().charAt(0);
            flag = result != 'n';
        }
    }

    public static void checkWord(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        try {
            LocalDate.parse(dateStr, formatter);
            System.out.printf("Веденная дата %s соответствует формату %s\n", dateStr, template);
        } catch (DateTimeParseException e) {
            System.out.printf("Веденная дата %s не соответствует формату %s\n", dateStr, template);
        }
    }
}
