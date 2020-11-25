package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class I1624_PairsWithSumLcci {

    public static void main(String[] args) {
        int[] nums = {5, 6, 5, 6};
        int target = 11;
        List<List<Integer>> res = pairSums(nums, target);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> pairSums(int[] nums, int target) {
        // 结果数组
        List<List<Integer>> res = new ArrayList<>();
        // 存放每个数字在数组中的个数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for (int num : nums) {
            // 目标值-当前值=匹配值，取出匹配值的个数
            Integer count = map.get(target - num);
            // 若存在匹配值且匹配值的个数大于0，说明当前值+匹配值=目标值
            if (count != null && count > 0) {
                // 存入数组
                res.add(Arrays.asList(num, target - num));
                // 匹配值使用了一个，所以个数-1，注意这里要先-1再存入，否则会出错
                map.put(target - num, --count);
            }
            // 统计每个数字在数组中的个数
            else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        // 返回结果
        return res;
    }

}
