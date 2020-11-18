package GreedyAlgorithm;

import java.util.Arrays;

public class p452_MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] points = {
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        };
        int res = findMinArrowShots(points);
        System.out.println("res = " + res);
    }

    public static int findMinArrowShots(int[][] points) {
        // 判空返回
        if (points.length < 1) {
            return 0;
        }
        // 对二维数组按照气球直径结束位置从小到大排序，目的是找出重叠区间
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        // 从第一个气球开始射，
        int temp = points[0][1];
        // 需要一个箭
        int res = 1;
        // 开始遍历
        for (int i = 0; i < points.length; i++) {
            // 如果不在一个重叠区间，说明这是第二块区域需要另一个箭，所以箭数+1，另外更新当前箭的射出位置为当前位置
            if (temp < points[i][0]) {
                res++;
                temp = points[i][1];
            }
        }
        // 返回结果
        return res;
    }

}
