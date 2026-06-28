/*
Question: Buy and Sell Stocks

Given prices[] where prices[i] is stock price on ith day.
Find maximum profit by choosing one day to buy and one future day to sell.

Approach:
Keep minimum buying price seen so far.
If current price is greater than buying price, calculate profit.
If current price is smaller, update buying price.

LeetCode:
LeetCode 121 - Best Time to Buy and Sell Stock
*/

public class BuyAndSellStocks {

    public static int buySell(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};

        System.out.println(buySell(prices));
    }
}