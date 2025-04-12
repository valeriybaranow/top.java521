package homeworks.Debugger;

import java.util.Scanner;

// TODO: : Нахождение ошибки в программе.
/**
 Вам предоставлена некорректная Java-программа, и ваша задача - найти и исправить ошибку с помощью отладки (debugging).
 */
public class Task01 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;
//        for (int i = 0; i <= numbers.length; i++) {
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("Сумма чисел: " + sum);
    }
}