package Package.Peterson_Solution;


/**
 * @Peterson Solution
 *
 * <p>
 * Peterson’s Solution is a classical algorithm for achieving mutual exclusion in
 * a two-process system. It was introduced by Gary Peterson in 1981 and
 * is a simple, elegant solution to the critical section problem in concurrent programming.
 * The solution ensures that only one process at a time can enter its critical section,
 * preventing conflicts over shared resources.
 * <p>
 * Peterson's algorithm is designed to work in systems where processes are required to cooperate
 * and access shared data, but race conditions must be prevented. The solution works without
 * using locks or semaphores, making it an important theoretical algorithm for understanding
 * concurrency.
 */


public class PetersonSolution {
    private int turn;              // Variable to indicate whose turn it is
    private boolean[] flag;        // Array to indicate if a process wants to enter its critical section

    // Constructor to initialize variables
    public PetersonSolution() {
        flag = new boolean[2];     // Only two processes (P0 and P1)
        turn = 0;                  // Initially, let P0 have the turn
    }

    // Process 0's critical section
    public void process0() {
        flag[0] = true;            // Indicate that P0 wants to enter the critical section
        turn = 1;                  // Give turn to P1
        while (flag[1] && turn == 1) {
            // Busy wait until P1 finishes or gives up
        }

        // Critical section for P0
        System.out.println("Process 0 is in the critical section");

        // Exit the critical section
        flag[0] = false;
    }

    // Process 1's critical section
    public void process1() {
        flag[1] = true;            // Indicate that P1 wants to enter the critical section
        turn = 0;                  // Give turn to P0
        while (flag[0] && turn == 0) {
            // Busy wait until P0 finishes or gives up
        }

        // Critical section for P1
        System.out.println("Process 1 is in the critical section");

        // Exit the critical section
        flag[1] = false;
    }
}

