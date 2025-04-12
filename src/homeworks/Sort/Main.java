package homeworks.Sort;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// TODO: Создать класс Sort с реализацией метода bubbleSort (если сложно, посмотрите справку)
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int colElements = scanner.nextInt();
        int[] arrayNumbs = new int[colElements];
        long startTime, endTime;

        for (int i = 0; i < arrayNumbs.length; i++) {
            Random random = new Random();
            arrayNumbs[i] = random.nextInt(100 - 1 + 1) + 1;
        }

        System.out.println(Arrays.toString(arrayNumbs));
        System.out.println();

        int[] arrayNumbs1 = Arrays.copyOf(arrayNumbs, arrayNumbs.length);
        startTime = System.nanoTime();
        Sort.bubbleSort(arrayNumbs1);
        endTime = System.nanoTime();
        System.out.println();
        System.out.println(Arrays.toString(arrayNumbs1));
        System.out.println("Время выполнения функции bubbleSort: " + (endTime - startTime)  + " миллисекунд");

        int[] arrayNumbs2 = Arrays.copyOf(arrayNumbs, arrayNumbs.length);
        startTime = System.nanoTime();
        Sort.selectionSort(arrayNumbs2);
        endTime = System.nanoTime();
        System.out.println();
        System.out.println(Arrays.toString(arrayNumbs2));
        System.out.println("Время выполнения функции selectionSort: " + (endTime - startTime)  + " миллисекунд");

        int[] arrayNumbs3 = Arrays.copyOf(arrayNumbs, arrayNumbs.length);
        startTime = System.nanoTime();
        Sort.mergeSort(arrayNumbs3);
        endTime = System.nanoTime();
        System.out.println();
        System.out.println(Arrays.toString(arrayNumbs3));
        System.out.println("Время выполнения функции mergeSort: " + (endTime - startTime)  + " миллисекунд");

        int[] arrayNumbs4 = Arrays.copyOf(arrayNumbs, arrayNumbs.length);
        startTime = System.nanoTime();
        Sort.insertionSort(arrayNumbs4);
        endTime = System.nanoTime();
        System.out.println();
        System.out.println(Arrays.toString(arrayNumbs4));
        System.out.println("Время выполнения функции insertionSort: " + (endTime - startTime)  + " миллисекунд");
    }
}
