package homeworks.String;

import java.util.Arrays;

// TODO: : Проверка на палиндром (boolean)

/**
     Напишите метод isPalindrome с помощью регулярных выражений и методов String. Можете пользоваться своими наработками, а можете создать с нуля и посмотреть, как вы выросли.      Вызывать в главном методе, передавая строчку на проверку.
     Выражения для проверки: «Madam, I'm Adam!», «Иди, Сеня, не сиди!».
 */
public class Task03 {
    public static void main(String[] args) {
        String string1 = "Madam, I'm Adam!";
        String string2 = "Иди, Сеня, не сиди!";
        if (isPalindrome(string1)) {
            System.out.println(string1 + " - is polindrom");
        } else {
            System.out.println(string1 + " - is not polindrom");
        }
    }

    public static boolean isPalindrome(String string) {
        String preparedString = string.toLowerCase().replaceAll("\\W+", "");
        for (int i = 0, j = preparedString.length()-1; i < j; i++, j-- ) {
            if (preparedString.charAt(i) != preparedString.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
