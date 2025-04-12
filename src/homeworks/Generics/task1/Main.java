package homeworks.Generics.task1;

/*
    Задача 1: Сравнение массивов
    Напишите обобщенный метод, который сравнивает два массива одного типа и возвращает true, если они равны (имеют одинаковые значения в одном и том же порядке) и false в противном случае.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] integersOne = {1,2,4,534,43};
        Integer[] integersTwo = {4,2,4,534,43};
        if(compare(integersOne, integersTwo)) {
            System.out.println("Массивы равны");
        } else {
            System.out.println("Массивы не равны");
        }

        String[] stringsOne = {"mather", "washes", "windows"};
        String[] stringsTwo = {"mather", "washes", "windows"};
        if(compare(stringsOne, stringsTwo)) {
            System.out.println("Массивы равны");
        } else {
            System.out.println("Массивы не равны");
        }
    }

    public static <T> boolean compare(T[] arrayOne, T[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) {
            return false;
        }
        for (int i = 0; i < arrayOne.length; i++) {
            if (!arrayOne[i].equals(arrayTwo[i])) {
                return false;
            }
        }
        return true;
    }
}
