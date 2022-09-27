package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class p448_FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = findDisappearedNumbers(nums);
        System.out.println("res = " + res);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int resIndex = 0;
        int[] map = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]]++;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

}
