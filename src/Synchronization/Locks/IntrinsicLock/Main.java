package Synchronization.Locks.IntrinsicLock;

/**
 * Intrinsic Lock -- synchronized keyword
 */

public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();

        Runnable task = new Runnable() {
            @Override

            public void run() {
                bankAccount.withdrawal(70);
            }
        };

        Thread t1 = new Thread(task, "Rahul");
        Thread t2 = new Thread(task, "Nikku");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Exception " + e);
        }
    }
}
