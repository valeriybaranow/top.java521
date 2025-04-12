package homeworks.Debugger;


import java.util.Arrays;

// TODO: : Нахождение ошибки в методе
/**
 Вам предоставлена часть Java-программы, содержащая метод для вычисления факториала числа. Однако метод содержит ошибку, и ваша задача - найти и исправить её с помощью отладки.
 */
public class Task02 {
    public static void main(String[] args) {
        int n = 5;
        int result = computeFactorial(n);
        System.out.println(n + "! = " + result);
    }

    public static int computeFactorial(int n) {
//        if (n == 2) {
        if (n == 1) {
            return 1;
        } else {
            int resultFunc = computeFactorial(n - 1);
            return n * computeFactorial(n - 1);
        }
    }
}
