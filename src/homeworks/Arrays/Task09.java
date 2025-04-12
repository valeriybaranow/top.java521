package homeworks.Arrays;

import java.util.Arrays;

// TODO: Предоставлен массив элементов и число, представляющее количество шагов для циклической ротации. Ваша задача - выполнить ротацию массива вправо на заданное количество шагов. Это может потребовать использования временных переменных и циклов для перемещения элементов.
public class Task09 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] tempNumbers = Arrays.copyOf(numbers, numbers.length);
        int[] rotates = {0, 1, 2, 10, 11, 21, -1, -2, -10, -11, -23};
        for (int rotate : rotates) {
            for (int i = 0; i < numbers.length; i++) {
                int rotateIndex = getRotateIndex(i, numbers, rotate);
                numbers[rotateIndex] = tempNumbers[i];
            }
            System.out.println(Arrays.toString(numbers));
        }
    }

    public static int getRotateIndex(int i, int[] numbers, int rotate)
    {
        int absoluteRotate = (i + rotate) % (numbers.length);
        return  absoluteRotate < 0 ? numbers.length + absoluteRotate : absoluteRotate;
    }
}