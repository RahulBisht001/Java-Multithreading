package Synchronization.Locks.ReadWriteLock;

public class Main {
    public static void main(String[] args) {

        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    System.out.println(Thread.currentThread().getName()
                            + " Read : " + counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented ");
                }
            }
        };

        Thread writeThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writeThread.start();
        readThread1.start();
        readThread2.start();

        try {
            writeThread.join();
            readThread1.join();
            readThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Final Count : " + counter.getCount());
        }

    }
}

