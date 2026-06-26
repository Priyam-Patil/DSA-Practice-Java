import java.util.*;

// Question:
// Given N ropes of different lengths, connect them into one rope with minimum cost.
// Cost to connect two ropes = sum of their lengths.
// To minimize cost, always connect the two smallest ropes first.

public class ConnectNRopesWithMinimumCost {

    public static int minCost(int length[], int n) {
        // PriorityQueue works as a Min Heap by default.
        // It removes the smallest value first.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int totalCost = 0;

        // Add all rope lengths into the priority queue.
        for (int i = 0; i < n; i++) {
            pq.add(length[i]);
        }

        // Continue until only one rope is left.
        while (pq.size() > 1) {
            // Remove the two smallest ropes and connect them.
            int curr = pq.remove() + pq.remove();

            // Add the current connection cost to total cost.
            totalCost += curr;

            // Add the newly connected rope back into the priority queue.
            pq.add(curr);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int length[] = {4, 3, 2, 6};
        int n = 4;

        System.out.println(minCost(length, n)); // 29
    }
}