/*
Question 3: Lexicographically smallest string of length N and sum K

We have two integers N and K.
The task is to print the lexicographically smallest string of length N
consisting of lower-case English alphabets such that the sum of the
characters of the string equals to K where
'a' = 1, 'b' = 2, 'c' = 3, ..... and 'z' = 26

Sample Input 1:
N = 5, K = 42

Sample Output 1:
aamz

Correction:
For N = 5, K = 42, correct output should be "aaamz",
because length should be 5.

LeetCode:
LeetCode 1663 - Smallest String With A Given Numeric Value
*/

import java.util.*;

public class LexicographicallySmallestStringOfLengthNAndSumK {

    public static void main(String[] args) {
        int n = 5;
        int k = 42;

        char res[] = new char[n]; // char arrays of size n

        Arrays.fill(res, 'a'); // initial fill all places by 'a'

        k -= n; // 'a'=1 ---> k=k-n

        while (k > 0) {
            // we creating lexocographically order string
            int add = Math.min(25, k);

            // res[n-1]=(char)(res[n-1]+Math.min(25,k));
            res[n - 1] += add; // here += automatically does type casting internally.

            k = k - add;
            n--;
        }

        System.out.println(String.valueOf(res));
    }
}