package GreedyAlgorithm;

/**
 * @Author: IronmanJay
 * @Description: 605.种花问题
 * @CreateTime: 2023-03-04  14:27
 */
public class p605_CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowered = {1, 0, 0, 0, 1};
        int n = 1;
        boolean res = canPlaceFlowers(flowered, n);
        System.out.println("res = " + res);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && ((i + 1) == flowerbed.length || flowerbed[i + 1] == 0) && (i == 0 || flowerbed[i - 1] == 0)) {
                flowerbed[i] = 1;
                res++;
            }
        }
        return res >= n;
    }

}
