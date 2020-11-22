package HashTable;

import java.util.Arrays;
import java.util.HashMap;

public class p645_SetMismatch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] res = findErrorNums(nums);
        System.out.println("res = " + Arrays.toString(res));
    }

    public static int[] findErrorNums(int[] nums) {
        // 判空返回
        if (nums.length == 0) {
            return nums;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        // 结果数组
        int[] res = new int[2];
        // 哈希表存放不重复元素
        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历整个数组
        for (int i = 0; i < nums.length; i++) {
            // 如果遇到重复值，放到结果数组的第一个位置，利用哈希表不存放重复元素的性质
            if (map.get(nums[i]) != null) {
                res[0] = nums[i];
            }
            // 如果不是重复的元素，说明合理，加入到哈希表中
            map.put(nums[i], nums[i]);
        }
        // 从1~n遍历哈希表，如果遍历到某个元素哈希表没存放这个key，说明这个就是缺失值，放到结果数组的第二个位置
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                res[1] = i;
            }
        }
        // 返回结果
        return res;
    }

}
