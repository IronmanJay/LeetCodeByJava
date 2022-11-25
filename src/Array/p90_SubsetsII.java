package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: IronmanJay
 * @Description: 90.子集 II
 * @CreateTime: 2022-11-25  09:04
 */
public class p90_SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs_back_p90_SubsetsII(nums, res, path, 0);
        return res;
    }

    public static void dfs_back_p90_SubsetsII(int[] nums, List<List<Integer>> res, List<Integer> path, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs_back_p90_SubsetsII(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
