package GreedyAlgorithm;

/**
 * @Author: IronmanJay
 * @Description: 135.分发糖果
 * @CreateTime: 2023-03-09  14:28
 */
public class p135_Candy {

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        int res = candy(ratings);
        System.out.println("res = " + res);
    }

    public static int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
        }
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 1;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }

}
