/*
Question: Fractional Knapsack Problem

Given weights and values of N items and a knapsack capacity W,
find the maximum total value that can be put in the knapsack.

You can take:
1. Complete item
2. Fraction of an item

Greedy Approach:
Calculate value/weight ratio for each item.
Pick items with highest ratio first.

Example:
value[]  = {60, 100, 120}
weight[] = {10, 20, 30}
W = 50

Output:
Final value is: 240.0

LeetCode:
Fractional Knapsack is not directly on LeetCode.
Closest: LeetCode 1710 - Maximum Units on a Truck
*/

import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;

        double ratio[][] = new double[value.length][2];

        // col:0-index, clo:1-ratio
        // ratio[i][0] stores original index
        // ratio[i][1] stores value/weight ratio
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i; // index
            ratio[i][1] = value[i] / (double) weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); // sort data in ascending order based on ratio

        // but we want ratio in descending order because higher is the ratio max is the value
        // so we traverse from last index

        int capacity = W;
        double totalValue = 0;

        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];

            if (capacity >= weight[idx]) {
                totalValue += value[idx];
                capacity -= weight[idx];
            } else {
                // adding fractional weight
                totalValue += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("Final value is: " + totalValue);
    }
}