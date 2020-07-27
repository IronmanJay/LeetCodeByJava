package HashTable;

import java.util.HashSet;
import java.util.Set;

public class p217_ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean res = containsDuplicate(nums);
        System.out.println("res = " + res);
    }

    public static boolean containsDuplicate(int[] nums) {
        // 利用HashSet不存储重复元素的性质
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

}
