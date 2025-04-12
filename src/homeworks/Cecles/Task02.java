package homeworks.Cecles;

import java.util.Arrays;
import java.util.Scanner;

// TODO: Напишите программу, которая проверяет, является ли введенная строка палиндромом (читается одинаково с начала и с конца, игнорируя пробелы и регистр букв). Сделать с помощью массива символов char.

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "y";
        String text;
        do {
            System.out.print("Введите текст: ");
            text = scanner.nextLine();

            String preparedText = text.replaceAll(" ", "").toLowerCase();
            char[] textChars = new char[preparedText.length()];
            char[] textCharsReverse = new char[preparedText.length()];
            int preparedTextLength = preparedText.length();

            for (
                 int i = 0, j = (preparedTextLength - 1);
                 i < preparedTextLength && j >= 0;
                 i++, j--
            ) {
                textChars[i] = preparedText.charAt(i);
                textCharsReverse[i] = preparedText.charAt(j);
            }

            if (Arrays.equals(textChars, textCharsReverse)) {
                System.out.println("Строка является полиндромом");
            } else {
                System.out.println("Строка не является полиндромом");
            }

            do {
                System.out.print("Вы хотите продолжить y/n: ");
                result = scanner.nextLine();
            } while (!(result.equals("y") || result.equals("n")));
        }
        while (!result.equals("n"));
        System.out.println("Выход из программы");
        scanner.close();
    }
}
