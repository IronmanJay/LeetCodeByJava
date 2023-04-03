package SlidingWindow;

/**
 * @Author: IronmanJay
 * @Description: 2379.得到 K 个黑块的最少涂色次数
 * @CreateTime: 2023-04-03  08:59
 */
public class p2379_MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        int res = minimumRecolors(blocks, k);
        System.out.println("res = " + res);
    }

    public static int minimumRecolors(String blocks, int k) {
        int sumW = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                sumW++;
            }
        }
        int res = sumW;
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                sumW += 1;
            }
            if (blocks.charAt(i - k) == 'W') {
                sumW -= 1;
            }
            res = Math.min(res, sumW);
        }
        return res;
    }

}
