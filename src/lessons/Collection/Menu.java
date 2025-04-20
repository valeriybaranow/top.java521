package lessons.Collection;

public class Menu {

    public static void welcome() {
        System.out.println("Привет! Это приложения для работы со списком.");
        System.out.println("--------------------");
    }

    public static void startMenu() {
        System.out.print("Введите через пробел числа для добавления их в список: ");
    }

    public static void mainMenu() {
        System.out.println("1. Добавить элемент в список.");
        System.out.println("2. Удалить элемент из списка");
        System.out.println("3. Показать содержимое списка.");
        System.out.println("4. Проверить есть ли значение в списке");
        System.out.println("5. Заменить значение в списке.");
    }
}

