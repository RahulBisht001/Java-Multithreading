package Difference;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExample {
    public static void main(String[] args) {

        Runnable task1 = new PrintInterface("Task 1");
        Runnable task2 = new PrintInterface("Task 2");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(task1);
        executor.execute(task2);

        executor.shutdown();

    }
}

class PrintInterface implements Runnable {

    private String message;

    public PrintInterface(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }
}