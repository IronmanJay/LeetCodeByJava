package DivideAndConquerAlgorithm;

import java.util.Arrays;

public class o40_TheSmallestNumberOfK {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 2;
        int[] res = getLeastNumbers(arr, k);
        System.out.println("res = " + Arrays.toString(res));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        // 获取数组长度
        int len = arr.length;
        // 判断边界值返回
        if (k == 0 || k > len) {
            return new int[0];
        }
        // 在数组中k就是索引，所以-1
        int target = k - 1;
        int left = 0;
        int right = len - 1;
        while (true) {
            // 返回中枢值索引
            int pIndex = partition(arr, left, right);
            // 恰好中枢值索引等于目标索引，说明前k个数已经按从小到大排序，直接返回即可
            if (pIndex == target) {
                int[] res = new int[k];
                for (int i = 0; i < k; i++) {
                    res[i] = arr[i];
                }
                return res;
            }
            // 如果中枢值索引小于目标索引，需要向右继续排序
            else if (pIndex < target) {
                left = pIndex + 1;
            }
            // 如果中枢值索引大于目标索引，需要向左继续排序
            else {
                right = pIndex - 1;
            }
        }
    }

    /**
     * 快速排序
     *
     * @param arr   待排序数组
     * @param left  左指针
     * @param right 右指针
     * @return 返回中枢值索引，并且中枢值左边的都是比中枢值小的数，中枢值右边的都是比中枢值大的数
     */
    private static int partition(int[] arr, int left, int right) {
        // 选取最左边元素为中枢值，随机化最好
        int pivot = arr[left];
        // 大于等于中枢值值的索引
        int leftEnd = left;
        // 将比中枢值小的元素都放到中枢值的左边
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                leftEnd++;
                swap(arr, leftEnd, i);
            }
        }
        // 将中枢值交换到中间位置
        swap(arr, left, leftEnd);
        // 返回中枢值索引
        return leftEnd;
    }

    /**
     * 交换数组中两个元素
     *
     * @param arr    待排序数组
     * @param index1 第一个数索引
     * @param index2 第二个树索引
     */
    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
