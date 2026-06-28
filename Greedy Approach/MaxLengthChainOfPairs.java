/*
Question: Maximum Length Chain of Pairs

You are given pairs where each pair has two numbers: (start, end).
A pair (c, d) can come after pair (a, b) only if:

b < c

Find the maximum length chain that can be formed.

Greedy Approach:
Sort pairs based on ending value.
Then always select the pair that ends earliest.

Example:
pairs = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}}

Output:
Maximum length of chain = 3

Chain:
{5,24} -> {27,40} -> {50,90}

LeetCode:
LeetCode 646 - Maximum Length of Pair Chain
*/

import java.util.*;

public class MaxLengthChainOfPairs {

    public static void main(String[] args) {
        int pairs[][] = {
            {5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}
        };

        // sort data in ascending order based on 2nd column/end value
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        ArrayList<Integer> a = new ArrayList<>();

        int chainLength = 1; // for 1st pair
        a.add(0); // add index of 1st selected pair after sorting

        int chainEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chainLength++;
                a.add(i);
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("Total chain length is: " + chainLength);

        for (int i = 0; i < a.size(); i++) {
            int idx = a.get(i);
            System.out.print("{" + pairs[idx][0] + "," + pairs[idx][1] + "} ");
        }
    }
}