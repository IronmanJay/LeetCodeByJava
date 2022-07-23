package Array;

public class p121_TheBestTimeToBuyAndSellStocks {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
        System.out.println(res);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if ((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

}
