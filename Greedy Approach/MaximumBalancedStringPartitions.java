/*
Question: Maximum Balanced String Partitions

Given a string containing only L and R.
Split the string into maximum number of balanced substrings.

Balanced substring:
Number of L == Number of R

Greedy Approach:
L -> +1
R -> -1
Whenever balance becomes 0, one balanced partition is completed.

LeetCode:
LeetCode 1221 - Split a String in Balanced Strings
*/

public class MaximumBalancedStringPartitions {
    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";

        int count = 0;
        int balanced = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'L') {
                balanced++;
            } else if (ch == 'R') {
                balanced--;
            }

            if (balanced == 0) {
                count++;
            }
        }

        System.out.println("Maximum balanced string partitions: " + count);
    }
}