package DSA_JAVA.java_files.DSA.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AthPerfectNumberWithQueue {

    public static int[] generateNumbers(int A) {
        int[] result = new int[A];
        int index = 0;

        // Handle the base case
        if (A > 0) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);

            while (index < A) {
                int current = queue.poll();
                result[index++] = current;

                // Generate the next numbers by appending 1, 2, and 3 to the current number
                queue.offer(current * 10 + 1);
                queue.offer(current * 10 + 2);
                queue.offer(current * 10 + 3);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        int A1 = 3;
        int[] result1 = generateNumbers(A1);
        System.out.println(Arrays.toString(result1));  // Output: [1, 2, 3]

        int A2 = 7;
        int[] result2 = generateNumbers(A2);
        System.out.println(Arrays.toString(result2));  // Output: [1, 2, 3, 11, 12, 13, 21]
    }
}