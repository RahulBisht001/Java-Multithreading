package Synchronization;

// Using Thread Class

public class MyThread extends Thread {

    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        // do something
        for (int i = 0; i < 10000; ++i) {
            counter.increment();
        }
    }
}


// // Using Runnable Interface


/*
public class MyThread implements Runnable {

    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        // do something
        for (int i = 0; i < 1000; ++i) {
            counter.increment();
        }
    }
}
*/