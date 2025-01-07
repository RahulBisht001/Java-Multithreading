package Difference;

public class ThreadExample {
    public static void main(String[] args) {

        // Each task requires a new Thread subclass
        Thread thread1 = new PrintThread("Task 1");
        Thread thread2 = new PrintThread("Task 2");

        thread1.start();
        thread2.start();
    }
}

class PrintThread extends Thread {
    private String message;

    public PrintThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }
}
