// Java Multithreading programs

public class Test {
    public static void main(String[] args) {

//        System.out.println("Multithreading");
//        System.out.println(Thread.currentThread().getName());

        World w = new World();
        World w2 = new World();

        w.start();


        for (int i = 0; i < 10000; ++i) {
            System.out.println("Hello");
        }

    }

}
