/*
Question: Minimum Absolute Difference Pairs

Given two arrays A and B of equal length n.
Pair each element of array A to an element in array B,
such that sum S of absolute difference of all the pairs is minimum.

Greedy Approach:
Sort both arrays.
Then pair A[i] with B[i].

LeetCode:
Closest: LeetCode 1200 - Minimum Absolute Difference
*/

import java.util.*;

public class MinAbsoluteDiffPairs {
    public static void main(String[] args) {
        int A[] = {1, 2, 3};
        int B[] = {2, 1, 3};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
            // 1-1=0
        }

        System.out.println("Min absolute difference of pairs = " + minDiff);
    }
}