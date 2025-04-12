package homeworks.String;

// TODO: :  Перевернуть строку (String)\
/**
 Условие: Напишите метод для переворота строки задом наперед с помощью массива символов.
 */
public class Task01 {
    public static void main(String[] args) {
        String string1 = "absd ef";
        String string2 = "absd efk";
        System.out.println(string1);
        string1 = revert1(string1);
        System.out.println(string1);

        System.out.println(string2);
        string2 = revert2(string2);
        System.out.println(string2);
    }

    public static String revert1(String string) {
        StringBuilder sb = new StringBuilder(string);
        for (int currentIndex = 0; currentIndex < string.length(); currentIndex++) {
            int mirrorIndex = string.length()-1-currentIndex;
            char currentChar = (string.charAt(currentIndex));
            char mirrorChar = (string.charAt(mirrorIndex));
            sb.setCharAt(currentIndex, mirrorChar);
            sb.setCharAt(mirrorIndex, currentChar);
        }
        return sb.toString();
    }

    public static String revert2(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0, j = chars.length-1; i < j; i++, j--) {
             char temp = chars[i];
             chars[i] = chars[j];
             chars[j] = temp;
        }
        return  new String(chars);
    }
}
