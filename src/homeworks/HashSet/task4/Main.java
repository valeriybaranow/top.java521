package homeworks.HashSet.task4;

import java.util.HashSet;
import java.util.Set;

/**
 *Задача 4: Разность множеств
 * Напишите метод, который принимает на вход два множества Set и возвращает новое множество,
 * содержащее только те элементы, которые присутствуют только в одном из исходных множеств.
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
        System.out.println(geExceptSet(set1, set2));
    }

    public static <E> Set<E> geExceptSet(Set<E> str1, Set<E> str2) {
        // поиск одинаковых элементов
        Set<E> confluxSet =  getConfluxSet(str1, str2);
        // слияние с удалением повторений
        Set<E> mergeSet =  mergedSet(str1, str2);
        // исключение из слитого одинаковых
        mergeSet.removeAll(confluxSet);
        return mergeSet;
    }


    public static <E> Set<E> getConfluxSet(Set<E> str1, Set<E> str2) {
        Set<E> temp = new HashSet<>(Set.copyOf(str1));
        temp.retainAll(str2);
        return temp;
    }

    public static <E> Set<E> mergedSet(Set<E>... strs) {
        Set<E> resul = new HashSet<>();
        for (Set<E> str : strs) {
            resul.addAll(str);
        }
        return resul;
    }
}
