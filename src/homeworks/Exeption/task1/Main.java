package homeworks.Exeption.task1;


import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Задача 1. Ввод данных:
    Напишите программу, которая запрашивает у пользователя ввод данных и пытается обработать этот ввод.
    Обработайте исключение InputMismatchException, которое возникает,
    если введенные данные не соответствуют ожидаемому формату.
 */
public class Main {

    static String template = "template";

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Введите слово для проверки: ");
            String word = scanner.nextLine();
            try {
                checkWord(word);
                System.out.printf("Веденное слово %s соответствует шаблону %s\n", word, template);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Вы желаете проложить? y/n");
            int result = scanner.nextLine().charAt(0);
            flag = result != 'n';
        }
    }

    public static void checkWord(String word) throws InputMismatchException {
        if (!word.equals(template)) {
            throw new InputMismatchException(String.format("Веденное слово %s не соответствует шаблону %s", word, template));
        }
    }
}
