package DoublePointer;

import java.util.Arrays;

/**
 * @Author: IronmanJay
 * @Description: 475.供暖器
 * @CreateTime: 2023-03-20  09:10
 */
public class p475_Heaters {

    public static void main(String[] args) {
        int[] houses = {1, 2, 3};
        int[] heaters = {2};
        int res = findRadius(houses, heaters);
        System.out.println("res = " + res);
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDis = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDis = Math.min(curDis, Math.abs(houses[i] - heaters[j]));
            }
            res = Math.max(curDis, res);
        }
        return res;
    }

}
