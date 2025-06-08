package lessons.Thread.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Start MyThread");
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println("Start MainThread");
        thread.setName("MainThread");

        MyThread myThread = new MyThread();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
        System.out.println(thread.getName());

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        Runnable task1 = () ->{
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Task 1 corrupt");
//               Thread.currentThread().interrupt();
//            }
//        };
//
//        Callable<String> task2  = () -> {
//            System.out.println(Thread.currentThread().getName());
//            Thread.sleep(2000);
//            return "Task 2";
//        };
//
//        try {
//            executorService.submit(task1);
//            Future<String> future = executorService.submit(task2);
//        } finally {
//            executorService.shutdown();
//        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            System.out.println(finalI);
            executorService.submit(() -> {
                System.out.println("Task " + finalI + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Task 1 corrupt");
                    Thread.currentThread().interrupt();
                }
            });
        }
        executorService.shutdown();
    }
}
