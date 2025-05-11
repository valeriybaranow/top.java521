package homeworks.HashSet.task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Задача 2: Объединение множеств.
 * Напишите метод, который принимает на вход два множества Set и возвращает новое множество,
 * содержащее все элементы из обоих исходных множеств.
 */
public class Main {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set2.add("a");
        set2.add("b");
        set2.add("c");
        System.out.println(mergeSets(set1, set2));
    }

    public static <E> List<E> mergeSets(Set<E>... strs) {
        List<E> resul = new ArrayList<>();
        for (Set<E> str : strs) {
            resul.addAll(str);
        }
        return resul;
    }
}
