package Tuan5;

import java.io.*;
import java.util.*;

public class b3 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        // Read the number of queries
        int q = scanner.nextInt();

        // Initialize a queue
        Queue<Integer> queue = new ArrayDeque<>();

        // Process the queries
        for (int i = 0; i < q; i++) {
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    // Enqueue operation
                    int element = scanner.nextInt();
                    queue.offer(element);
                    break;
                case 2:
                    // Dequeue operation
                    if (!queue.isEmpty()) {
                        queue.poll();
                    }
                    break;
                case 3:
                    // Print front element
                    if (!queue.isEmpty()) {
                        System.out.println(queue.peek());
                    }
                    break;
                default:
                    System.out.println("Invalid operation");
            }
        }

        scanner.close();
    }
}
