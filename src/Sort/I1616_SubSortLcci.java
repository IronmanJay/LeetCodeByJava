package Sort;

import java.util.Arrays;

public class I1616_SubSortLcci {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] ints = subSort(array);
        System.out.println("res = " + Arrays.toString(ints));
    }

    public static int[] subSort(int[] array) {
        // 复制一个数组，用于后续比较
        int[] temp = array.clone();
        // 定义结果数组
        int[] res = {-1, -1};
        // 对原数组进行排序
        Arrays.sort(array);
        // 开始遍历对比对应位置的元素
        for (int i = 0; i < array.length; i++) {
            // 只有原数组和复制的数组不对应的位置就是发生排序改变的位置
            if (temp[i] != array[i]) {
                // 第一个遇到的不对应的位置就是开始位置
                if (res[0] == -1) {
                    res[0] = i;
                }
                // 第二个遇到的不对应的位置就是结束位置
                res[1] = i;
            }
        }
        // 返回结果
        return res;
    }

}
