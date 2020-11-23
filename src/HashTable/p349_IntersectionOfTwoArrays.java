package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class p349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] res = intersection(num1, num2);
        System.out.println("res = " + Arrays.toString(res));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        // 结果数组
        ArrayList<Integer> arr = new ArrayList<>();
        // 哈希表存放不重复元素
        HashMap<Integer, Integer> map = new HashMap<>();
        // 使用增强for循环遍历第一个数组，key存放数组值，value存放表示当前值出现过，方便和第二个数组的集合去重
        for (int num : nums1) {
            map.put(num, 1);
        }
        // 使用增强for循环遍历第二个数组，只要遇到key一样说明有交集，并且遇到交集之后这个key对应的value-1，防止出现集合出现重复元素
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                arr.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        // ArrayList转数组
        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        // 返回结果
        return res;
    }

}
