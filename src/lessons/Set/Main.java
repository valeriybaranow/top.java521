package lessons.Set;


import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Set коллекция с уникальными элементами
        // HashSet and TreeSet
        // HashSet - hashCode equals
        // TreeSet - коллекция с уникальными упорядоченными элементы
//        task1();
//        task2();
        task3();
//        task4();
    }

    public static void task1() {
        HashSet<Task> todoList = new HashSet<>();
        todoList.add(new Task("Купить молоко"));
        todoList.add(new Task("Покормить кота"));
        todoList.add(new Task("Купить хлеб"));
        todoList.add(new Task("Купить молоко"));
        todoList.add(new Task("Купить хлеб"));
        todoList.add(new Task("Купить творог"));

//        todoList.clear();

        todoList.remove("Купить творог");
        todoList.size();

        for (Task item: todoList) {
            System.out.println(item);
        }
    }

    public static void task2() {
        HashSet<Task> todoList = new HashSet<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            Task task = new Task("Некая задача нашего списка " + (int) (Math.random() * 1000));
            todoList.add(task);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Task.getEqualsCounter());
    }

    public static void task3() {
        System.out.println("task3");
        HashSet<Task> todoList = new HashSet<>();
        todoList.add(new Task("Покормить лошадь"));

        System.out.println(todoList.contains(new Task("покормить лошадь")));
    }

    public static void task4() {
        HashSet<Task> todoList = new HashSet<>();
        todoList.add(new Task("Купить молоко"));
        todoList.add(new Task("Покормить кота"));
        todoList.add(new Task("Купить хлеб"));
        todoList.add(new Task("Купить молоко"));
        todoList.add(new Task("Купить хлеб"));
        todoList.add(new Task("Купить творог"));

        for (Task task: todoList) {
            System.out.println(task.hashCode());
            System.out.println(task);
        }
    }
}
