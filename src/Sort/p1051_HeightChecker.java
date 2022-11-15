package Sort;

/**
 * @Author: IronmanJay
 * @Description: 1051.高度检查器
 * @CreateTime: 2022-11-15  08:59
 */
public class p1051_HeightChecker {

    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        int res = heightChecker(heights);
        System.out.println("res = " + res);
    }

    public static int heightChecker(int[] heights) {
        int maxHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
            }
        }
        int[] count = new int[maxHeight + 1];
        for (int h : heights) {
            count[h]++;
        }
        int index = 0;
        int res = 0;
        for (int i = 1; i <= maxHeight; i++) {
            for (int j = 1; j <= count[i]; j++) {
                if (heights[index] != i) {
                    res++;
                }
                index++;
            }
        }
        return res;
    }

}
