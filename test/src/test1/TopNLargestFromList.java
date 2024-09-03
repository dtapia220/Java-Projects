import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class TopNLargestFromList {
    /**
     * Finds the top N largest unique numbers from a list and calculates their sum.
     * 
     * @param list The input list containing numbers.
     * @param N    The number of top largest unique numbers to find.
     */
    public static void findTopNLargestSum(List<Integer> list, int N) {
        // Use a HashSet to filter out duplicate numbers from the list
        HashSet<Integer> uniqueSet = new HashSet<>(list);

        // Convert the HashSet back to a List to maintain the original order for
        // processing
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);

        // Create a min-heap to store the top N largest elements
        // PriorityQueue in Java is a min-heap by default
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(N);

        // Iterate over each number in the unique list
        for (int num : uniqueList) {
            // If the heap has less than N elements, add the current number
            if (minHeap.size() < N) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                // If the heap is full and the current number is larger than the smallest in the
                // heap
                minHeap.poll(); // Remove the smallest element from the heap
                minHeap.offer(num); // Add the current number to the heap
            }
        }

        // Collect the top N largest elements from the min-heap
        List<Integer> topNLargest = new ArrayList<>(minHeap);
        // Sort the collected elements in descending order
        Collections.sort(topNLargest, Collections.reverseOrder());

        // Calculate the sum of the top N largest elements
        int sum = 0;
        for (int num : topNLargest) {
            sum += num;
        }

        // Output the top N largest unique numbers and their sum
        System.out.println("Top " + N + " largest unique numbers: " + topNLargest);
        System.out.println("Sum of the top " + N + " largest unique numbers: " + sum);
    }

    public static void main(String[] args) {
        // Sample list with some duplicate values
        List<Integer> list = List.of(5, 1, 7, 3, 9, 8, 6, 5, 7);
        // Number of top largest unique numbers to find
        int N = 3;

        // Find and display the top N largest unique numbers and their sum
        findTopNLargestSum(list, N);
    }
}