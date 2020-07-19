package GreedyAlgorithm;

public class p122_BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
        System.out.println("res = " + res);
    }

    public static int maxProfit(int[] prices) {
        // 结果
        int res = 0;
        // 只要后一天比前一天能赚钱，就是后一天的值>前一天的值，也就是利润>0，这就是局部最优解，贪心算法的思想
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        // 返回结果
        return res;
    }

}
