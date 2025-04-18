package homeworks.Generics.task2;

import java.util.Arrays;

/*
    Задача 2: Слияние массивов
    Напишите обобщенный метод для слияния двух массивов одного типа в один.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] integersOne = {1,2,4,534,43};
        Integer[] integersTwo = {4,2,4,534,43};
        Integer[] result = merge(integersOne, integersTwo);
        System.out.println(Arrays.deepToString(result));

        String[] stringsOne = {"mather", "washes", "windows"};
        String[] stringsTwo = {"neighbour", "washes", "dishes"};
        String[] stringsResult = merge(stringsOne, stringsTwo);
        System.out.println(Arrays.deepToString(stringsResult));
    }

    public static <T> T[]  merge(T[] arrayOne, T[] arrayTwo) {
        int length = arrayOne.length + arrayTwo.length;
        T[] resultArray = Arrays.copyOf(arrayOne, length);
        for (int i = arrayTwo.length, j = 0; i < length && j < arrayTwo.length; i++, j++) {
            resultArray[i] = arrayTwo[j];
        }
        return resultArray;
    }
}
