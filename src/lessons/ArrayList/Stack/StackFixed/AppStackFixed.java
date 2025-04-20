package lessons.ArrayList.Stack.StackFixed;

import lessons.ArrayList.Stack.Menu;
import lessons.ArrayList.Stack.StackSimple.StackSimple;

import java.util.Scanner;

public class AppStackFixed {
    private final StackFixed stack = new StackFixed();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int menuItem = 0;
        Menu.showWelcome();
        while (menuItem != 9) {
            Menu.showMenu();
            menuItem = scanner.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.printf("Введите число для добавления в стек: ");
                    try {
                        stack.push(scanner.nextInt());
                        System.out.println("Значение добавлено в стек");
                    } catch (Exception e) {
                        System.out.println("Невозможно добавить значение в стек - стек полный");
                    }
                    break;
                case 2:
                    try {
                        System.out.println(stack.pop());
                        System.out.println("Значение удалено из стека");
                    } catch (Exception e) {
                        System.out.println("Невозможно получить значение из стека - стек пустрой");
                    }
                    break;
                case 3:
                    System.out.println("Размер стека - " + stack.size());
                    break;
                case 4:
                    System.out.println(stack.empty() ? "стек пустой" : "стек не пустой");
                    break;
                case 5:
                    System.out.println(stack.full() ? "стек полный" : "стек не полный");
                    break;
                case 6:
                    stack.clear();
                    System.out.println("Стек очищен");
                    break;
                case 7:
                    System.out.println("верхнее значение" + stack.seek());
                    break;
                case 8:
                    stack.printItems();
                    break;
                case 9:
                    System.out.println("Работа программы завершена");
                    return;
            }
            System.out.printf("Для продолжения нажмите любой символ: ");
            scanner.next();
        }
    }
}
