package homeworks.HashSet.task3;

import java.util.HashSet;
import java.util.Set;

/**
 * Задача 3: Пересечение множеств/
 * Напишите метод, который принимает на вход два множества Set и возвращает новое множество,
 * содержащее только те элементы, которые присутствуют в обоих исходных множествах.
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
        set2.add("f");
        System.out.println(getConfluxSet(set1, set2));
    }

    public static <E> Set<E> getConfluxSet(Set<E> str1, Set<E> str2) {
        Set<E> temp = new HashSet<>(Set.copyOf(str1));
        temp.retainAll(str2);
        return temp;
    }
}
