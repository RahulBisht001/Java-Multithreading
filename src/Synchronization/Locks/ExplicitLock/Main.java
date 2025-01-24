package Synchronization.Locks.ExplicitLock;

/**
 * Using Lock Interface for building our own
 * lock mechanism.
 */

public class Main {
    public static void main(String[] args) {

        BankAccount HDFC = new BankAccount();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                HDFC.withdrawal(60);
            }
        };

        Thread t1 = new Thread(task, "Rahul");
        Thread t2 = new Thread(task, "Papa");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

            System.out.println("Everything is done.");
        } catch (InterruptedException e) {
            System.out.println("Exception " + e);
        }
    }
}
