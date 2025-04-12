package homeworks.Arrays;

import java.util.Scanner;

// TODO: У вас есть двумерный массив чисел, например, матрица. Ваша задача - написать программу, которая находит сумму всех элементов в этом массиве.
public class Task05 {
    public static void main(String[] args) {
        int[][] numbers = {
            {10, 2, 4, 5, 3, 3, 10, 10, 5, 6},
            {1, 22, 34, 5, 43, 43, 130, 120, 45, 6},
        };
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                sum += numbers[i][j];
            }
        }
        System.out.println("Сумма многомерного массива " + sum);
    }
}
