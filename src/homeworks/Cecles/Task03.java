package homeworks.Cecles;

import java.util.Scanner;

// TODO: Напишите программу для создания пирамиды из звездочек с заданным количеством уровней. Используйте вложенные циклы for.

/**
 * Пример ввода:
 * Введите количество уровней пирамиды: 5
 *
 * Пример вывода:
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 */

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        int maxLevel;
        do {
            System.out.print("Введите количество уровней пирамиды: ");
            if (scanner.hasNextInt()) {
                maxLevel = scanner.nextInt();
                if (maxLevel < 1) {
                    scanner.nextLine();
                    System.out.println("Введенное количество не можте быть меньше 1.");
                    continue;
                }
            } else {
                scanner.nextLine();
                System.out.println("Ошибка!!! Вы ввели некорректные данные.");
                continue;
            }

            // проход по уровням пирамиды
            for (int currentLevel = 1; currentLevel <= maxLevel; currentLevel++) {
                drawingLine(maxLevel, currentLevel); // отрисовать строку
                System.out.println(); // перейти на новую строку
            }

            scanner.nextLine();
            do {
                System.out.print("Вы хотите продолжить y/n: ");
                result = scanner.nextLine();
            } while (!(result.equals("y") || result.equals("n")));
        }
        while (!result.equals("n"));
        System.out.println("Выход из программы");
        scanner.close();
    }

    public static void drawingLine(int level, int i) {
        int countStarsInBaseLevel = getCountStarsInLevel(level);
        int countStarsInCurrentLevel =  getCountStarsInLevel(i); // количество звездочек
        int countEmptyValuesInRow = (countStarsInBaseLevel - countStarsInCurrentLevel); // количество пустых символов
        drawingSymbols(countEmptyValuesInRow / 2, ' ');
        drawingSymbols(countStarsInCurrentLevel, '*');
        drawingSymbols(countEmptyValuesInRow / 2, ' ');
    }

    public static void drawingSymbols(int count, char symbol) {
        for (int j = 0; j < count; j++) {
            System.out.print(symbol);
        }
    }

    public static int getCountStarsInLevel(int level) {
        return 2 * level - 1;
    }
}
