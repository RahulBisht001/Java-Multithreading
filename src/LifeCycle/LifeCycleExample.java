/**
 * Thread Life cycle state
 * 1. new
 * 2. runnable
 * 3. running
 * 4. wait/ blocked
 * 5. terminated
 */

package LifeCycle;

public class LifeCycleExample implements Runnable {

    public static void main(String[] args) throws InterruptedException {

        Runnable r = new LifeCycleExample();

        Thread t1 = new Thread(r);
//        System.out.println(t1.getState()); // New State



        t1.start();

        System.out.println( Thread.currentThread().getName() + " Thread is Running");

//        System.out.println(t1.getState()); // Runnable State

        Thread.sleep(2000);

        System.out.println(Thread.currentThread().getName() + " awake");
//        System.out.println(t1.getState()); // Waiting/Blocked State

        t1.join();
//        System.out.println(t1.getState()); // TERMINATED

    }

    @Override
    public void run() {
//        System.out.println("Running State");


        try {
            System.out.println(Thread.currentThread().getName() + " is Running");
            Thread.sleep(5000);

            System.out.println(Thread.currentThread().getName() + " awake");
        } catch (InterruptedException e) {
//            System.out.println(e);
        }

    }
}
