package homeworks.String;

/**
    Условие: Напишите метод для проверки правильности формата даты в строке (например, "гггг-мм-дд").
 Проверка правильности формата даты (boolean)

 */
public class Task04 {
    public static void main(String[] args) {
        String string = "2025-11-10";
        System.out.println(string + (isCorrect(string) ? " - is correct" : " is not correct"));

        string = "1-01-10";
        System.out.println(string + (isCorrect(string) ? " - is correct" : " is not correct"));

        string = "2999-12-31";
        System.out.println(string + (isCorrect(string) ? " - is correct" : " is not correct"));

        string = "0-12-10";
        System.out.println(string + (isCorrect(string) ? " - is correct" : " is not correct"));

        // год некорректен
        string = "3000-01-10";
        System.out.println(string + (isCorrect(string) ? " - is correct" : " is not correct"));

        // месяц некорректен
        string = "2025-13-10";
        System.out.println(string + (isCorrect(string) ? " - is correct" : " is not correct"));

        string = "2025-23-10";
        System.out.println(string + (isCorrect(string) ? " - is correct" : " is not correct"));

        string = "2025-00-32";
        System.out.println(string + (isCorrect(string) ? " - is correct" : " is not correct"));

        // дата некорректна
        string = "2025-12-32";
        System.out.println(string + (isCorrect(string) ? " - is correct" : " is not correct"));

        string = "2025-12-42";
        System.out.println(string + (isCorrect(string) ? " - is correct" : " is not correct"));

        string = "2025-12-00";
        System.out.println(string + (isCorrect(string) ? " - is correct" : " is not correct"));
    }

    public static boolean isCorrect(String string) {
        return string.matches("[1-2]?[0-9]{0,3}+-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|[3][0-1])");
    }
}
