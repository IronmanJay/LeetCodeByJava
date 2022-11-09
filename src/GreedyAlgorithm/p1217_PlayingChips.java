package GreedyAlgorithm;

/**
 * @Author: IronmanJay
 * @Description: 1217.玩筹码
 * @CreateTime: 2022-11-09  09:10
 */
public class p1217_PlayingChips {

    public static void main(String[] args) {
        int[] position = {1, 2, 3};
        int res = minCostToMoveChips(position);
        System.out.println("res = " + res);
    }

    public static int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }

}
