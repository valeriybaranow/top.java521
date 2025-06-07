package homeworks.Files;


import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean showContinueMenu(Boolean isFinished) {
        Boolean isContinue = false;
        while (isContinue == false) {
            System.out.print("Вы хотите продолжить? (y/n): ");
            String input = App.scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                System.out.println("Продолжаем работу...");
                isContinue = true;
            } else if (input.equals("n")) {
                isContinue = true;
                isFinished = true;
                System.out.println("Завершение программы.");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Некорректный ввод. Введите 'y' или 'n'.");
            }
        }
        return isFinished;
    }
}
