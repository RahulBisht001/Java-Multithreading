package Synchronization.Locks.IntrinsicLock;

/**
 * Either use synchronized keyword with the method
 * or else use synchronized block
 * <p>
 * <p>
 * e.g
 * <p>
 * synchronized(this){
 * <p>
 * // critical section
 * <p>
 * }
 */

public class BankAccount {
    private int balance = 100;

    public synchronized void withdrawal(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdrawal "
                + amount);

        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            balance -= amount;
            System.out.println("Transaction completed");
            System.out.println("Current Balance " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }
    }
}
