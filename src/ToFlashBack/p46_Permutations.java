package ToFlashBack;

import java.util.ArrayList;
import java.util.List;

public class p46_Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> permute(int[] nums) {
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
        // 开始回溯遍历
        dfs(nums, path, res, used, len, 0);
        // 返回结果
        return res;
    }

    public static void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] used, int len, int depth) {
        // 如果当前遍历的深度和数组长度一样说明找到了一个排列，加入结果数组，并将此次递归返回
        if (depth == len) {
            // 这里要new，否则返回空数组，因为直接加入是地址引用，必须拷贝一下数据值才能得到结果
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历数组中每一个元素为第一个开始的排列
        for (int i = 0; i < len; i++) {
            // 只有当前元素没有使用过才可以做第一个开始的排列
            if (!used[i]) {
                // 将当前元素加入排列路经
                path.add(nums[i]);
                // 将当前元素置为已经使用
                used[i] = true;
                // 以当前元素开始递归遍历所有可能的结果，深度+1
                dfs(nums, path, res, used, len, depth + 1);
                // 从这里开始回溯，回到上一个状态，也就是当前元素还没有被使用
                used[i] = false;
                // 并将已经得到的结果元素删除，充值状态
                path.remove(path.size() - 1);
            }
        }
    }

}
