package Synchronization.Locks.ExplicitLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * It is an interesting simulation.
 * <p>
 * If you compare it with the intrinsic lock, you will find that in the console output
 * there is no error type output instead both threads will attempt to withdrawal and
 * due to "synchronized" keyword at a time only one of them can do the withdrawal process, hence
 * other one has to wait.
 * <p>
 * but after the wait you will see one has completed its withdraw operation while other is showing
 * insufficient balance.
 * <p>
 * <p>
 * But in the Explicit lock (ReentrantLock)
 * you will find that we have a tryLock method (with time ).
 * there one will acquire the lock and other will try lock meaning wait for given lock time
 * and if the lock is freed in that time, it will enter in it.
 * otherwise give else (showing error output on console)
 * <p>
 * in our case, for one of the Thread it will always show the "transaction error output"
 * because if you see there we have Thread.sleep(3000) and tryLock only for 1 sec.
 * hence anyone will definitely go in the else part.
 * <p>
 * however, if you want to see the same kind of output behaviour here as well.
 * then comment out the Thread.sleep
 * basically the withdrawal processing time must be lower than tryLock(time)
 * so that lock can wait to release the lock and then acquire.
 */


public class BankAccount {
    private int balance = 100;

    // Explicit Lock ✅
    private final Lock lock = new ReentrantLock();

    public void withdrawal(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdrawal "
                + amount);

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

                if (balance >= amount) {

                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        balance -= amount;
                        Thread.sleep(3000);
                        System.out.println("Transaction completed");
                        System.out.println("Current Balance is Rs. " + balance);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                        lock.unlock();
                        System.out.println();
                    }

                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " something went wrong! Please Try Again");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
