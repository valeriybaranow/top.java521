package lessons.TaskFour;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber;
        double secondNumber;
        double thirdNumber;
        firstNumber = scanner.nextDouble();
        secondNumber = scanner.nextInt();
        thirdNumber = scanner.nextInt();
        System.out.println(""+firstNumber+secondNumber+thirdNumber);
    }
}
