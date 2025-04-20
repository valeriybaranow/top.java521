package lessons.ArrayList.Stack;

import java.util.Scanner;

public class Menu {

    public static void showWelcome() {
        System.out.println("Привет! Это приложения для работы со стеком.");
    }

    public static void showMenu() {
        System.out.println("1 - для добавления значения в стек");
        System.out.println("2 - выталкивание целого значения из стека");
        System.out.println("3 - подсчет количества целых в стеке");
        System.out.println("4 - проверку пустой ли стек");
        System.out.println("5 - проверку полный ли стек");
        System.out.println("6 - очистить стека");
        System.out.println("7 - получить значения без выталкивания верхнего целого в стеке");
        System.out.println("8 - отобразить стек");
        System.out.println("9 - для выхода из программы");
        System.out.printf("Выберите пункт меню: ");
    }
}
