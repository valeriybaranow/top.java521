package lessons.StillOop;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array <T> {
    private static final int COUNT_ELEMENT_MAX = 5;
    private T[] array = (T[]) new Object[COUNT_ELEMENT_MAX];
//    private T[] array;
    int current = 0;

    public void addItems() {
        current = 0;
        while(current < COUNT_ELEMENT_MAX) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите значение массива: ");
            int temp = scanner.nextInt();
            array[current++] = (T) Integer.valueOf(temp);
        }
    }

    public void addItemsRandom() {
        Random rn = new Random();
        for (int i = 0; i < array.length; i++) {
            int temp = rn.nextInt((100 - 1) + 1);
            array[i] = (T) Integer.valueOf(temp) ;
        }
    }

    @Override
    public String toString() {
        return "Array{" +
                "array=" + Arrays.toString(array) +
                ", current=" + current +
                '}';
    }
}
