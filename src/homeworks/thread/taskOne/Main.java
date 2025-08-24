package homeworks.thread.taskOne;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    Создать файл на N количество слов.

    Запустить потоки для
    1) Посчитать количество слов
    2) Посчитать количество предложений
    3) Посчитать количество букв
    4) Посчитать количество чисел
    5) Посчитать количество гласных
 */
public class Main {
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Task(i));
            threads.add(thread);
            thread.start();
        }

        // Ожидаем завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все потоки завершили работу.");


        try (ExecutorService executor = Executors.newFixedThreadPool(5)) {
            for (int i = 0; i < 10; i++) {
                executor.submit(new Task(i));
            }
            executor.shutdown(); // Плавное завершение
        }
    }
}

class Task implements Runnable {
    private final int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task " + id + " выполняется в потоке " + Thread.currentThread().getName());
            // Имитация работы
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Поток " + id + " был прерван!");
            Thread.currentThread().interrupt(); // Восстанавливаем статус прерывания
        }
    }
}
