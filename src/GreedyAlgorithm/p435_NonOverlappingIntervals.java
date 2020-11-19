package GreedyAlgorithm;

import java.util.Arrays;

public class p435_NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int res = eraseOverlapIntervals(intervals);
        System.out.println("res = " + res);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        // 判空返回
        if (intervals.length == 0) {
            return 0;
        }
        // 对二维数组以最后一个元素从小到大排序，目的是找到不重叠区间
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        // 第一个小区间设为第一个不重叠区间，count表示不重叠区间的个数
        int count = 1;
        int temp = intervals[0][1];
        // 开始遍历
        for (int i = 1; i < intervals.length; i++) {
            // 如果是不重叠区间，那么不重叠区间的小区间个数+1，并且更新整个不重叠区间的尾部位置，以便下一次比较，如果遇到重叠区间直接跳过
            if (temp <= intervals[i][0]) {
                count++;
                temp = intervals[i][1];
            }
        }
        // 全部的小区间减去全部的小区间组成的不重叠区间的个数就是需要去掉的小区间
        return intervals.length - count;
    }

}
