package homeworks.Arrays;

// TODO: У вас есть одномерный массив целых чисел. Ваша задача - найти наименьший элемент в этом массиве с использованием цикла foreach.
public class Task04 {
    public static void main(String[] args) {
        int[] numbers = {10,2,4,5,3,3,10,10,5,6};
        int minElement = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minElement) {
                minElement = numbers[i];
            }
        }
        System.out.println("Минимальный элемент массива " + minElement);
    }
}
