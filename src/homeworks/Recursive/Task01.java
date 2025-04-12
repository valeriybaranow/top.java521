package homeworks.Recursive;

import java.util.Scanner;

// TODO: Вывести числа в строку Фибоначчи до введенного пользователем числа в отдельном методе и подсчитать количество.
/**
 Input: 20
 Output: 0,1,1,2,3,5,8,13, count - 8
 */
public class Task01 {
    static String result = "";
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        int depth = scanner.nextInt();
        getFibonacciNumber(0, 0, depth);
        System.out.println("Output: " + result + ", count - " + count);
        scanner.close();
    }

    //  0,1,1,2,3,5,8,13
    public static void getFibonacciNumber(int current, int prev, int depth)
    {
        int nextNumber = 1;
        if (current >= depth) {
            return;
        }

        if (current == 0) {
            nextNumber = 1;
        }
        if (current == 1) {
            nextNumber = prev == 1 ? current + prev : 1;
        }

        if (current > 1) {
           nextNumber = current + prev;
        }
        result += current == 0 ? current : "," + current;
        count++;
        getFibonacciNumber(nextNumber, current,  depth);
    }
}