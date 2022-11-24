package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IronmanJay
 * @Description: 78.子集
 * @CreateTime: 2022-11-24  09:02
 */
public class p78_Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs_back(0, nums, res, path);
        return res;
    }

    public static void dfs_back(int start, int[] nums, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs_back(i + 1, nums, res, path);
            path.remove(path.size() - 1);
        }
    }

}
