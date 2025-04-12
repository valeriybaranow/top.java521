package homeworks.Arrays;

import java.util.Arrays;

// TODO: Предоставлен массив чисел и значение, которое нужно найти. Ваша задача - определить, содержит ли массив заданное значение, и если да, то найти индекс этого значения в массиве.
public class Task03 {
    public static void main(String[] args) {
        int[] numbers = {10,2,4,5,3,3,10,10,5,6};
        int findNumber = 3;
        System.out.println("Массив: " + Arrays.toString(numbers));
        boolean isFind = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == findNumber) {
                if (!isFind) {
                    isFind = true;
                    System.out.print("Число " + findNumber +  " есть в массиве в эелменте с индексом: " + i);
                } else {
                    System.out.print(", " + i);
                }
            }
        }
//        int number1 = 525;
//        int number2 = 231;
//        int number3 = 1;
//
//        while (number3 > 0) {
//            number3 = number1 % number2;
//            number1 = number2;
//            number2 = number3;
//        }
//        System.out.println(number1);
    }
}
