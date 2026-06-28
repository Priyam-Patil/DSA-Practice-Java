/*
Question: Kth Largest Odd Number in a Range

Given range L to R and integer K.
Find the kth largest odd number in that range.

Greedy/Math Approach:
Start from R.
If R is even, make it odd by doing R--.
Then every previous odd number decreases by 2.

LeetCode:
This exact problem is not directly on LeetCode.
*/

public class KthLargestOddNumberInARange {

    public static int kthLargest(int L, int R, int K) {
        if (R % 2 == 0) {
            // if R is even then
            R--; // so largest odd before even
        }

        int ans = R - 2 * (K - 1); // Odd numbers decrease by 2.

        if (ans < L) {
            return 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        int L = 3;
        int R = 16;
        int K = 4;

        System.out.println(kthLargest(L, R, K));

        // odd numbers b/w 3 to 16 are
        // 3,5,7,9,11,13,15
        // for K=4 ans=9
    }
}