/*
Question: Chocola Problem

Minimum cost to cut board/chocolate/cake into squares.

Greedy Approach:
Sort horizontal and vertical cut costs in descending order.
Always choose the maximum cost cut first.

LeetCode:
LeetCode 3218 - Minimum Cost for Cutting Cake I
LeetCode 3219 - Minimum Cost for Cutting Cake II
*/

// important

import java.util.*;

public class ChocolaProblem {

    public static void main(String[] args) {
        int n = 4, m = 6;

        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        // sort arrays in descending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        // initializations
        int h = 0, v = 0; // track the indeces of both arrays

        int hp = 1, vp = 1; // vertical and horizotal piece is 1 initially
        // hp = horizontal pieces
        // vp = vertical pieces

        int minCost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) {
                // first do the max cost cut
                // horizontal cut
                minCost += costHor[h] * vp;
                h++;
                hp++;
            } else {
                // vertical cut
                minCost += costVer[v] * hp;
                v++;
                vp++;
            }
        }

        // remaining cuts
        while (h < costHor.length) {
            minCost += costHor[h] * vp;
            h++;
            hp++;
        }

        while (v < costVer.length) {
            minCost += costVer[v] * hp;
            v++;
            vp++;
        }

        System.out.println("Minimum cost is: " + minCost); // 42
    }
}