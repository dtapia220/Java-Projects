import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class TopNLargestFromHashSet {
    public static PriorityQueue<Integer> findTopNLargest(HashSet<Integer> set, int N) {
        if (set == null || set.size() < N) {
            throw new IllegalArgumentException("Set must contain at least N numbers.");
        }

        // Min-Heap to store the top N largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(N);

        for (int num : set) {
            if (minHeap.size() < N) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        return minHeap;
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, 5, 1, 7, 3, 9, 8, 6);
        int N = 3;

        PriorityQueue<Integer> topN = findTopNLargest(set, N);
        System.out.println("Top " + N + " largest numbers: " + topN);
    }
}
