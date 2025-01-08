// Talking about Thread Methods

package Thread_Methods;

public class MyThread extends Thread {
    /**
     * Thread Methods.
     * <p>
     * 1. run <p>
     * 2. start <p>
     * 3. join <p>
     * 4. sleep <p>
     * 5. setPriority <p>
     * 6. interrupt <p>
     * 7. setDaemon <p>
     *
     *     Although there are several other methods as well but these are some of
     *     most used ones for threading.
     *
     */

    public MyThread() {
        super();
    }

    /**
     * @param name Calling the constructor of Thread class will create a new
     *             thread object and passing name to the thread.
     */
    public MyThread(String name) {
        super(name);
    }

    public static void main(String[] args) {

        MyThread t1 = new MyThread("Thread rahul");

        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();


//        t1.setName("Venom");
        t1.setPriority(Thread.MAX_PRIORITY);

        t2.start();
        t3.start();
        t1.start();

//        t1.interrupt();

        Thread.yield();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread completed.");

    }

    @Override
    public void run() {
        System.out.println("Thread is Running ...");


//        try {
//            for (int i = 1; i <= 5; ++i) {
//                System.out.println("Number " + i);
//                Thread.sleep(1000);
//            }
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }


        // Set Priority method

        for (int i = 1; i <= 5; ++i) {
            System.out.println(Thread.currentThread().getName() +
                    " - Priority : " + Thread.currentThread().getPriority()
                    + " - count : " + i);
            try {

                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}