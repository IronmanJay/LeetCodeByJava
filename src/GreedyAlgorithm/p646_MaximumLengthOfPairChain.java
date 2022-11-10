package GreedyAlgorithm;

import java.util.Arrays;

/**
 * @Author: IronmanJay
 * @Description: 646.最长数对链
 * @CreateTime: 2022-11-10  09:06
 */
public class p646_MaximumLengthOfPairChain {

    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        int res = findLongestChain(pairs);
        System.out.println("res = " + res);
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (cur < pairs[i][0]) {
                cur = pairs[i][1];
                res++;
            }
        }
        return res;
    }

}
