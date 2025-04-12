package homeworks.Arrays;

// TODO: У вас есть трехмерный массив чисел, представляющий собой набор матриц. Ваша задача - вычислить среднее значение всех элементов в этом трехмерном массиве.
public class Task06 {
    public static void main(String[] args) {
        int[][][] numbers = {
            {
                {1, 2, 3, 4}, {5, 1, 1, 2}, // 10 + 10 = 20
            },
            {
                {1, 1, 1, 4}, {1, 2, 1, 4}, // 7 + 8 = 15
            },
        };
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                for (int k = 0; k < numbers[i][j].length; k++) {
                    sum += numbers[i][j][k];
                }
            }
        }
        int count = numbers.length * numbers[0].length * numbers[0][0].length;
        System.out.println("Среднее: " + (double) sum/count ); // 35/16
    }
}
