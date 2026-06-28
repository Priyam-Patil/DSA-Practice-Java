/*
Question: Indian Coins Problem

We are given an infinite supply of denominations.
Find min no. of coins/notes to make change for a value V.

Greedy Approach:
Sort coins in descending order.
Always choose the largest possible coin/note first.

LeetCode:
Exact Indian Coins greedy problem is not on LeetCode.
Closest: LeetCode 322 - Coin Change, but it uses DP.
*/

import java.util.*;

public class IndianCoins {

    public static void main(String[] args) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        // sort array in descending order
        // keep array as Integer[] not int[]
        Arrays.sort(coins, Collections.reverseOrder());

        ArrayList<Integer> a = new ArrayList<>();

        int countOfCoins = 0;
        int amt = 590;

        for (int i = 0; i < coins.length; i++) {
            // use while loop for to check the same coins again
            while (coins[i] <= amt) {
                countOfCoins++;
                a.add(coins[i]);
                amt -= coins[i];
            }
        }

        System.out.println("Minimum used coins are: " + countOfCoins);

        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
    }
}