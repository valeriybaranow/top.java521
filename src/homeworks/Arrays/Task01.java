package homeworks.Arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// TODO: Напишите программу, которая переворачивает массив, так чтобы последний элемент стал первым, предпоследний - вторым и так далее. Используйте Random для заполнения массива. Вывести свои было и стало.

/**
 * Пример было:
 * [5, 4, 3, 2, 1]
 * Стало:
 * [1, 2, 3, 4, 5]
 */

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        int[] numbersReverse = new int[10];
        Random rn = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rn.nextInt((100 - 1) + 1);
        }
        System.out.println("Было: " + Arrays.toString(numbers));
        for (int i = 0, j = numbers.length - 1; i < numbers.length; i++, j--) {
            numbersReverse[i] = numbers[j];
        }
        System.out.println("Стало: " + Arrays.toString(numbersReverse));

        // TODO: подсмотрел на уроке решение с одним массивом
        for (int i = 0; i < numbers.length/2; i++) {
            int temp = numbers[numbers.length -1 - i];
            numbers[numbers.length -1 - i] = numbers[i];
            numbers[i] = temp;
        }
        System.out.println("Стало: " + Arrays.toString(numbers));
        scanner.close();
    }
}
