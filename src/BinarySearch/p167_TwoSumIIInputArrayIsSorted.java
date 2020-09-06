package BinarySearch;

import java.util.Arrays;

public class p167_TwoSumIIInputArrayIsSorted {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(numbers, target);
        System.out.println("res = " + Arrays.toString(res));
    }

    public static int[] twoSum(int[] numbers, int target) {
        // 遍历每一个值，但是如果遇到符合要求的就退出for循环，所以说不一定遍历到底
        for (int i = 0; i < numbers.length; i++) {
            /*
                这里low = i + 1是因为我们要从数组第一个元素开始固定，
                从后面的数组查找target和固定值的差值，就变成了二分查找数组的问题了
            */
            int low = i + 1;
            // 二分查找尾部固定是整个数组长度
            int high = numbers.length - 1;
            while (low <= high) {
                // 定义中间值索引
                int mid = (high - low) / 2 + low;
                /*
                    如果在除去固定值的数组中，查找到了target和固定值的差值，说明固定值+当前这个值就是目标值，
                    因为数组有序，说明index1<index2，符合要求，返回下标即可，按照要求，分别+1
                */
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                }
                // 如果在除去固定值的数组中，发现中间值大于target和固定值的差值，说明我们要找的在中间值左边，向左查找
                else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                }
                // 如果在除去固定值的数组中，发现中间值小于target和固定值的差值，说明我们要找的在中间值右边，向左查找
                else {
                    low = mid + 1;
                }
            }
        }
        // 如果没找到，返回-1数组
        return new int[]{-1, -1};
    }

}
