package homeworks.String;

/**
     Задача 5: Замена всех чисел в строке на символ "X" (String)
     Условие: Напишите метод для замены всех чисел в строке на символ "X".
     Было: "There are 3 cats and 2 dogs in the yard."
     Стало: There are X cats and X dogs in the yard.
 */
public class Task05 {
    public static void main(String[] args) {
        String string = "2025-? asdfd 11-10";
        System.out.println(string);
        string = replaceOnX(string);
        System.out.println(string);
    }

    public static String replaceOnX(String string) {
        return string.replaceAll("\\d", "X");
    }
}
