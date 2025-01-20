package Package.Peterson_Solution;

public class Main {
    public static void main(String[] args) {
        PetersonSolution ps = new PetersonSolution();


        // Thread constructor can take multiple type of arguments.
        // here instead of giving a runnable object we're providing a lambda
        // expression as an argument.
        // so don't confuse.


        // Thread for Process 0
        Thread t0 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                ps.process0();
            }
        });

        // Thread for Process 1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                ps.process1();
            }
        });

        // Start the threads
        t0.start();
        t1.start();

        // Wait for threads to finish
        try {
            t0.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both processes have finished execution.");
    }
}