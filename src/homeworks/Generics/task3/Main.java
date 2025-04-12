package homeworks.Generics.task3;

/*
    Задача 3: Поиск элемента
    Напишите обобщенный метод для поиска элемента в массиве. Метод должен принимать массив и элемент для поиска, а затем возвращать индекс этого элемента в массиве. Если элемент не найден, вернуть -1.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] integers = {1,2,4,534,43};
        System.out.println("Индекс элемента массива: " + find(integers, 534));
        String[] strings = {"mather", "washes", "windows"};
        System.out.println("Индекс элемента массива: " + find(strings,"windows"));
    }

    public static <T> int find(T[] array, T elem) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }
}
