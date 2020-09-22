package ToFlashBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p47_PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        // 新建结果数组
        List<List<Integer>> res = new ArrayList<>();
        // 获取数组长度
        int len = nums.length;
        // 判空返回
        if (len == 0) {
            return res;
        }
        // 新建排列路经数组
        List<Integer> path = new ArrayList<>();
        // 判断对应元素是否使用过
        boolean[] used = new boolean[len];
        // 只有排序了才能剪枝，升序降序都可以，遇到重复数并且前一个重复的未使用就剪枝
        Arrays.sort(nums);
        // 开始回溯遍历
        dfs(nums, res, path, len, used, 0);
        // 返回结果
        return res;
    }

    public static void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int len, boolean[] used, int depth) {
        // 如果当前递归的深度和数组长度一样说明找到了一个排列，加入结果数组，并将此次递归返回
        if (depth == len) {
            // 这里要new，否则返回空数组，因为直接加入是地址引用，必须拷贝一下数据值才能得到结果
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历数组中每一个元素为第一个开始的排列
        for (int i = 0; i < len; i++) {
            // 只有当前元素没有使用过才可以做第一个开始的排列，否则跳出当前循环
            if (used[i]) {
                continue;
            }
            // i > 0是为了保证nums[i - 1]有意义
            // nums[i] == nums[i - 1]目的是剪枝的前提是这个数字是重复的
            // !used[i-1]是为了保证前一个重复的数字未使用过，这样说明之前回溯过已经使用了，如果再使用就会产生重复结果，这也就是剪枝的条件
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 将当前元素加入排列路经
            path.add(nums[i]);
            // 将当前元素置为已经使用
            used[i] = true;
            // 以当前元素开始递归遍历所有可能的结果，深度+1
            dfs(nums, res, path, len, used, depth + 1);
            // 从这里开始回溯，回到上一个状态，也就是当前元素还没有被使用
            used[i] = false;
            // 并将已经得到的结果元素删除，重置状态
            path.remove(path.size() - 1);
        }
    }

}
