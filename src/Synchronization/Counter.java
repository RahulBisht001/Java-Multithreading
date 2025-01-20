package Synchronization;

public class Counter {
    private int count = 0;

//    public synchronized void increment() {
//        count += 1;
//    }

    public void increment() {
        synchronized (this) {
            count += 1;
        }
    }

    public int getCount() {
        return count;
    }
}
