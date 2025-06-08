package lessons.Thread;

class MyThread extends Thread {
    String result;

    @Override
    public void run() {
        this.setName("MyThread");
        System.out.println("Hello myThread " + this.getName());
        result = "test " + this.getName();
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(final String result) {
        this.result = result;
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
            синхронное и асинхронное программирование
            асинхронное программирование - задачи выполняются параллельно - дает скорость и производительность -
            женщина готовит еду, стирает, и пр. как бы параллельно
            синхронное - последовательно - утром все делаем последовательно
         */
        Thread thread = Thread.currentThread();
        thread.setName("MainThread");


//        System.out.println(thread.getPriority());
//        thread.setPriority(Thread.MAX_PRIORITY);
//        System.out.println(thread.isAlive()); // жив или нет
//        System.out.println(thread.isInterrupted()); // прерван
//        thread.join();
//        thread.run(); // запускает поток внутри себя
//        thread.start(); // запускает поток и он выполняется не в текущем потоке
//        thread.sleep(5 * 1000); //  wait 5 second
//        System.out.println(thread.getName());

        System.out.println("Start " + thread.getName());
        MyThread child = new MyThread();
        child.start();
        System.out.println("End " + thread.getName());

        child.join();
        System.out.println(child.getResult());


    }
}
