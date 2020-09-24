package ToFlashBack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class p216_CombinationSumIII {

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        List<List<Integer>> res = combinationSum3(k, n);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        // 结果List
        List<List<Integer>> res = new ArrayList<>();
        // 路径数组
        Deque<Integer> path = new ArrayDeque<>();
        // 开始搜索
        dfs(k, n, res, path, 1);
        // 返回结果
        return res;
    }

    /**
     * @param k     还需要的元素个数
     * @param n     目标值
     * @param res   结果数组
     * @param path  路径数组
     * @param index 这个可以理解为待查数组
     */
    public static void dfs(int k, int n, List<List<Integer>> res, Deque<Integer> path, int index) {
        // 如果目标值n最后减的小于0说明当前和后面的数字都大于目标值，剪枝，因为从1~9有序排列
        if (n < 0) {
            return;
        }
        // 如果目标值n等于0并且k等于0说明找到一个成功组合的，并且符合要求长度，不再需要新的元素，那么添加这条路径即可
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 这里之前用过的数字不能再用，否则会出现重复的组合，并且因为从1~9有序排列，所以遍历到9
        for (int i = index; i <= 9; i++) {
            // 将当前结点添加到路径中
            path.addLast(i);
            // 开始递归搜索
            // k-1就是因为路径加入了一个元素，那么所需长度也就减少一个
            // n-i就是做减法，最后目标值n等于0就是成功找到一个组合
            // i+1就是下次递归不能选取当前值，避免重复
            dfs(k - 1, n - i, res, path, i + 1);
            // 这里回溯，重置状态
            path.removeLast();
        }
    }

}
