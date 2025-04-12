package homeworks.String;

import java.util.Arrays;

// TODO: :  Проверка на анаграммы (boolean)
/**
    Напишите метод для проверки areAnagrams, принимающего 2 строки, являются ли они анаграммами (имеют одни и те же символы в разном порядке).
 */
public class Task02 {
    public static void main(String[] args) {
        String string1 = "Astronomers";
        String string2 = "No more stars";
        if (areAnagrams(string1, string2)) {
            System.out.println("Arrays is equals");
        } else {
            System.out.println("Arrays is not equals");
        }
    }

    public static boolean areAnagrams(String string1, String string2) {
        return Arrays.equals(stringToSortedChars(string1), stringToSortedChars(string2));
    }

    public static char[] stringToSortedChars(String string) {
        char[] chars = string.toLowerCase().replace(" ", "").toCharArray();
        Arrays.sort(chars, 0, chars.length);
        System.out.println(chars);

        return chars;
    }
}
