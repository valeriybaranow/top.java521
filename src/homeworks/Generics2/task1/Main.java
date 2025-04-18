package homeworks.Generics2.task1;

/*
    Шаблонные методы
    Задание 1.
    Напишите шаблонный метод, который возвращает максимум из двух переданных параметров.
    Задание 2.
    Напишите шаблонный метод, который возвращает максимум из трёх переданных параметров.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(max(22.7, 3.8));
        System.out.println(max(1, 4));
        System.out.println(max(22, 3));
        System.out.println(max("a", "b", "c"));
    }

    @SafeVarargs
    public static <T extends Comparable <T>> T max(T... vals) {
        T max = vals[0];
        for (T val : vals) {
            if (val.compareTo(max) > 0) {
                max = val;
            }
        }
        return max;
    }
}
