package Synchronization.Locks.Others.Fairness;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {
    /**
     * Here if you can see that the lock is unfair. we don't know which thread will
     * get the lock first. So, the thread which is waiting for the lock will get the lock first.
     * <p>
     * adding (fair: true) argument to the constructor will make the lock fair.
     * Which means
     */

    private final Lock unfairLock = new ReentrantLock(true);

    public void accessResource() {
        unfairLock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        } finally {

            System.out.println(Thread.currentThread().getName() + " released the lock.");
            unfairLock.unlock();
        }
    }

    public static void main(String[] args) {

        UnfairLockExample ex = new UnfairLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                ex.accessResource();
            }
        };


        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");


        t2.start();
        t3.start();
        t1.start();
    }
}










