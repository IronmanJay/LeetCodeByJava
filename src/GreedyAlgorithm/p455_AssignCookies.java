package GreedyAlgorithm;

import java.util.Arrays;

public class p455_AssignCookies {

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        int res = findContentChildren(g, s);
        System.out.println("res = " + res);
    }

    public static int findContentChildren(int[] g, int[] s) {
        // 存储结果
        int res = 0;
        // 对数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 孩子和饼干的数组指针
        int gindex = 0;
        int sindex = 0;
        // 孩子和饼干的数组长度
        int glen = g.length;
        int slen = s.length;
        // 只要饼干消耗完或者孩子已经喂完就结束
        while (sindex < slen && gindex < glen) {
            // 获取当前饼干的尺寸
            int cookiesSize = s[sindex++];
            // 给没喂的孩子喂饼干，只要饼干的尺寸大于等于孩子的胃口就能满足要求，这里体现贪心算法的思想，遇到满足胃口的孩子就可以
            for (int i = gindex; i < glen; i++) {
                // 如果遇到了满足要求的孩子，当前的饼干被消耗，不再计算，当前的孩子也已经喂了，不再计算，直接break掉，等待下一次匹配
                if (cookiesSize >= g[i]) {
                    res++;
                    gindex++;
                    break;
                }
            }
        }
        // 返回结果
        return res;
    }

}
