package GreedyAlgorithm;

/**
 * @Author: IronmanJay
 * @Description: 714.买卖股票的最佳时机含手续费
 * @CreateTime: 2022-11-11  08:53
 */
public class p714_BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int res = maxProfit(prices, fee);
        System.out.println("res = " + res);
    }

    public static int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }
        int base = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > base) {
                profit += prices[i] - base;
                base = prices[i];
            } else if (base > prices[i] + fee) {
                base = prices[i] + fee;
            }
        }
        return profit;
    }

}
