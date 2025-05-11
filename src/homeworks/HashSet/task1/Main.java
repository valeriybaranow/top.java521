package homeworks.HashSet.task1;

import java.util.HashSet;
import java.util.Set;

/**
 * Задача 1: Проверка на уникальность.
 * Напишите метод, который принимает на вход строку и проверяет, содержит ли она все уникальные символы.
 * Метод должен вернуть true, если все символы в строке уникальны, и false в противном случае.
 */
public class Main {
    public static void main(String[] args) {
        String str1 = "нет пары";
        String str2 = "c уникальными";
        System.out.println(isAllSymbolsUnique(str1) ? "все символы в строке уникальны" : "в строке есть повторяющиеся символы");
        System.out.println(isAllSymbolsUnique(str2) ? "все символы в строке уникальны" : "в строке есть повторяющиеся символы");
    }

    public static boolean isAllSymbolsUnique(String string) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            set.add(string.charAt(i));
        }
        return set.size() == string.length();
    }
}
