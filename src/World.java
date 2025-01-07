/**
 * Creating a new Thread
 */

public class World extends Thread {

    @Override
    public void run() {
//        super.run();

        for (int i = 0; i < 10000; ++i) {
            System.out.println("World");
        }
    }
}
