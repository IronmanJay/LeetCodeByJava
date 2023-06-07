package Stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: IronmanJay
 * @Description: 1475.商品折扣后的最终价格
 * @CreateTime: 2023-06-07  10:02
 */
public class p1475_FinalPricesWithASpecialDiscountInAShop {

    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        int[] res = finalPrices(prices);
        System.out.println("res = " + Arrays.toString(res));
    }

    public static int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }

}
