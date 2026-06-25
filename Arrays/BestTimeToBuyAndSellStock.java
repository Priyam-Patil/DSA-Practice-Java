// Question:
// Given an array prices where prices[i] is the stock price on the ith day,
// return the maximum profit from one buy and one sell transaction.
// If profit is not possible, return 0.

// LeetCode 121 - Best Time to Buy and Sell Stock

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price > buyPrice) {
                int profit = price - buyPrice; // today's profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = price; // update minimum buying price
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices)); // 5
    }
}