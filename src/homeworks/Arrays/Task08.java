package homeworks.Arrays;

import java.util.Arrays;

// TODO: Предоставлен массив элементов, включая возможные дубликаты. Ваша задача - создать новый массив, который не содержит повторяющихся элементов. *Эта задача может быть решена с использованием или сортировки.
public class Task08 {
    public static void main(String[] args) {
        int[] numbers = {10, 2, 4, 5, 3, 3, 10, 10, 5, 6};
        int[] newNumbers = Arrays.copyOf(numbers, numbers.length);
        for (int i = 0; i < newNumbers.length; i++) {
            for (int j = 0; j < newNumbers.length; j++) {
                if (newNumbers[i] == newNumbers[j] && i != j) {
                    // сделать повторяющийся элемент последним
                    int temp = newNumbers[j];
                    newNumbers[j] = newNumbers[newNumbers.length-1];
                    newNumbers[newNumbers.length-1] = temp;
                    // удалить последний элемент
                    newNumbers = Arrays.copyOf(newNumbers, newNumbers.length-1);
                }
            }
        }
        System.out.println(Arrays.toString(newNumbers));
    }
}
