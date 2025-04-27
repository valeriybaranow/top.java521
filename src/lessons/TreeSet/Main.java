package lessons.TreeSet;



import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // TreeSet - коллекция с уникальными упорядоченными элементы
//        task1();
//        task2();
        // методы contains clear remove size
//        task3();
        task4();
    }

    public static void task1() {
        Comparator<Task> comparator = new Comparator<>() {
            @Override
            public int compare(Task o1, Task o2) {
                return 0;
            }
        };
        TreeSet<Task> todoList = new TreeSet<>(comparator);
        todoList.add(new Task("Купить молоко"));
        todoList.add(new Task("Покормить кота"));
        todoList.add(new Task("Купить хлеб"));
        todoList.add(new Task("Купить молоко"));
        todoList.add(new Task("Купить хлеб"));
        todoList.add(new Task("Купить творог"));
        todoList.add(new Task("Купить творог"));

        for (Task item: todoList) {
            System.out.println(item);
        }
    }

    public static void task2() {
        Comparator<Student> comparator = Comparator
                .comparing((Student s) -> s.getName())
                .thenComparingInt(s -> s.getId()).reversed();
        TreeSet<Student> student = new TreeSet<>(comparator);
        student.add(new Student("Анисимов", 1, 22.2));
        student.add(new Student("Баранов", 33, 22.2));
        student.add(new Student("Баранов", 3, 22.2));
        student.add(new Student("Баранов", 4, 22.2));

        for (Student item: student) {
            System.out.println(item);
        }
    }

    public static void task3() {
        TreeSet<Task> todoList = new TreeSet<>();
        todoList.add(new Task("Купить молоко"));
        todoList.add(new Task("Покормить кота"));
        todoList.add(new Task("Купить хлеб"));
        todoList.add(new Task("Купить молоко"));
        todoList.add(new Task("Купить хлеб"));
        todoList.add(new Task("Купить творог"));
        todoList.add(new Task("Купить творог"));
        todoList.add(new Task("Бить баклуши"));

        System.out.println(todoList.pollFirst());
        System.out.println(todoList.pollFirst());
        System.out.println(todoList.floor(new Task("Бить баклуши")));
        System.out.println(todoList.higher(new Task("Бить баклуши")));
        System.out.println(todoList.lower(new Task("Бить баклуши")));
        System.out.println(todoList.headSet(new Task("Купить молоко")));
        // до не включая
        System.out.println(todoList.headSet(new Task("Купить молоко")));
        // включая и до конца
        System.out.println(todoList.tailSet(new Task("Купить молоко")));
        // от и до не включая
        System.out.println(todoList.subSet(new Task("Купить молоко"), new Task("Купить хлеб")));

        for (Task item: todoList) {
            System.out.println(item);
        }
    }

    public static void task4() {
        TreeSet<Task> todoList = new TreeSet<>();
        todoList.add(new Task("Купить молоко"));
        todoList.add(new Task("Покормить кота"));
        todoList.add(new Task("Купить хлеб"));
        todoList.add(new Task("Купить молоко"));
        todoList.add(new Task("Купить хлеб"));
        todoList.add(new Task("Купить творог"));
        todoList.add(new Task("Бить баклуши"));

        for (Task item: todoList) {
            System.out.println(item);
        }
    }
}
