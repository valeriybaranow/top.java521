package homeworks.Arrays;

// TODO: Предоставлен массив чисел. Ваша задача - найти подмассив (последовательность элементов) с наибольшей суммой элементов. Эта задача называется задачей максимальной подпоследовательности (maximum subarray problem) и может быть решена с использованием алгоритма Кадана.
public class Task10 {
    public static void main(String[] args) {
        int[] numbers = {5, -3, 1, -7, 4, -2, 4, -1, -8, 2};
        int sum = 0;
        int maxSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (sum > maxSum) maxSum = sum;
            if (sum < 0) sum = 0;
        }
        System.out.println(maxSum);

        StringBuffer world = new StringBuffer("test");
        System.out.println(world);

    }
}