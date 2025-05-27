package homeworks.Exeption.task3;


import java.util.Scanner;

/*
    Задача 3*. Подсчет факториала
    Напишите программу, которая запрашивает у пользователя целое число и вычисляет его факториал.
    Факториал числа nn (обозначается n!n!) - это произведение всех целых чисел от 1 до nn.
    Например, 5!=5×4×3×2×1=1205!=5×4×3×2×1=120.
    Однако, для решения этой задачи предусмотрите возможность ввода отрицательных чисел.
    В случае, если пользователь ввел отрицательное число,
    выбросьте специальное исключение NegativeNumberException, а затем обработайте его, выводя сообщение об ошибке.
    Вот отдельный класс ошибки, который также необходимо создать.
    class NegativeNumberException extends Exception {
        public NegativeNumberException(String message) {
            super(message);
        }
    }
 */
public class Main {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Введите число для вычисления факториала: ");
            int number = scanner.nextInt();
            try {
                System.out.println("Факториал числа - " + calculateFactorial(number));
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Вы желаете проложить? y/n");
            scanner.nextLine();
            int result = scanner.nextLine().charAt(0);
            flag = result != 'n';
        }
    }

    public static long calculateFactorial(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException("Число должно быть больше 0");
        }
        long factorial = 1;

        if (number == 0) {
            factorial = 0;
        } else {
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
        }

        return factorial;
    }
}
