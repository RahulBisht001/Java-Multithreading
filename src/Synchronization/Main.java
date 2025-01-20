package Synchronization;

public class Main {
    public static void main(String[] args) {

        Counter cnt = new Counter();

        MyThread t1 = new MyThread(cnt);
        MyThread t2 = new MyThread(cnt);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(cnt.getCount());
    }
}
