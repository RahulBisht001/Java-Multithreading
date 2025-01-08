// Java Multithreading programs

public class Test {
    public static void main(String[] args) {


//        System.out.println(Thread.currentThread().getName());

        World w = new World();

//        w.start();

        Runnable p = new Planet();
        Thread t1 = new Thread(p);
        t1.start();


        for (int i = 0; i < 10; ++i) {
            System.out.println("Hello");
        }

    }

}
