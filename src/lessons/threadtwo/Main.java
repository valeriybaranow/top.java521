package lessons.threadtwo;

import java.util.concurrent.Semaphore;

/**
 * Колизии
 * 1. Блокировка ресурса
 * 2. AtomicInteger
 * 3. synchronized
 * 4. Semaphore
 * 5. Пометить метод как synchronized
 * 6. мьютекс
 */
class Counter {
    int count = 0;
    Object lock = new Object();
//    private ReentrantLock lock = new ReentrantLock();
//    AtomicInteger value = new AtomicInteger();

    private Semaphore semaphore = new Semaphore(1);

    public synchronized void increment() {

        count++;
//        lock.lock();
//        count++;
//        lock.unlock();
//        value.incrementAndGet();

//        synchronized (lock) {
//            count++;
//        }

//        try {
//            semaphore.acquire();
//            count++;
//        } catch (InterruptedException e) {
//            semaphore.release();
//            throw new RuntimeException(e);
//        }


    }

    public synchronized void decrement() {
        count--;

//        synchronized (lock) {
//            count--;
//        }

//        lock.lock();
//        count--;
//        lock.unlock();

//        value.decrementAndGet();
    }

    public void clear() {
        count = 0;
    }

    public int getCount() {
        return count;
//        return value;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return count + "";
    }
}

class IncrementTask extends Thread {
    private Counter counter;

    public IncrementTask(Counter counter) {
        this.counter = counter;
    }

    public Counter getCounter() {
        return counter;
    }

    public void run() {
        for (int i = 0; i < 10_000; i++) {
            counter.increment();
        }
    }
}

class DecrementTask extends Thread {
    private Counter counter;

    public DecrementTask(Counter counter) {
        this.counter = counter;
    }

    public Counter getCounter() {
        return counter;
    }

    public void run() {
        for (int i = 0; i < 10_000; i++) {
            counter.decrement();
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");

        Counter counter = new Counter();
        IncrementTask incrementTask = new IncrementTask(counter);
        DecrementTask decrementTask = new DecrementTask(counter);

        incrementTask.start();
        decrementTask.start();

        incrementTask.join();
//        System.out.println("Counter ++ => " + decrementTask.getCounter().getCount());
        decrementTask.join();
//        System.out.println("Counter ++ => " + decrementTask.getCounter().getCount());


        Counter result = incrementTask.getCounter();
        System.out.println("Counter => " + result);

        System.out.println("end");


//        int count = 0;
//
//        System.out.println("Start");
//
//        for (int i = 0; i < 1_000_000; i++) {
//            count++;
//            System.out.println(count);
//        }
//        System.out.println("Count " + count);
//
//        for (int i = 0; i < 1_000_000; i++) {
//            count--;
//            System.out.println(count);
//        }
//        System.out.println("Count " + count);
//
//        System.out.println("End");
    }
}
