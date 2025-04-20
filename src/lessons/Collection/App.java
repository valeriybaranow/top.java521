package lessons.Collection;


import java.util.Scanner;

public class App {
    ListInt listInt = new ListInt();
    public void start() {
        Menu.welcome();
        Menu.startMenu();
        Scanner scanner = new Scanner(System.in);
        String list = scanner.nextLine();
        listInt.stringToList(list);
        int menuItem = 0;
        int value;
        int index;
        Menu.welcome();
        while (menuItem != 6) {
            Menu.mainMenu();
            System.out.print("Выберите пункт меню: ");
            menuItem = scanner.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("Введите число в список: ");
                    value = scanner.nextInt();
                    listInt.add(value);
                    System.out.print("Введено число список");
                    break;
                case 2:
                    System.out.println("Введите индекс для получения: ");
                    index = scanner.nextInt();
                    listInt.remove(index);
                    break;
                case 3:
                    listInt.printItems();
                    break;
                case 4:
                    System.out.println("Введите число для проверки: ");
                    value = scanner.nextInt();
                    System.out.println(listInt.contains(value) ? "есть" : "нет");
                    break;
                case 5:
                    System.out.println("Введите индекс для изменения: ");
                    index = scanner.nextInt();
                    System.out.println("Введите число для изменения: ");
                    value = scanner.nextInt();
                    listInt.set(index, value);
                    System.out.print("Значение заменено в списке");
                    break;
                case 6:
                    System.out.println("Работа программы завершена");
                    return;
            }
        }
    }
}
