package ToFlashBack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class p39_CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 获取数组长度
        int len = candidates.length;
        // 结果List
        List<List<Integer>> res = new ArrayList();
        // 判空返回
        if (len == 0) {
            return res;
        }
        // 路径数组
        Deque<Integer> path = new ArrayDeque();
        // 开始搜索
        dfs(candidates, 0, len, target, path, res);
        // 返回结果
        return res;
    }

    /**
     * @param candidates 待选数组
     * @param begin      搜索起点
     * @param len        数组长度
     * @param target     目标值，每减一个元素，目标值变小
     * @param path       表示路径
     * @param res        结果集
     */
    public static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target为负数说明当前搜索失败，没找到对应的组合，因为做减法，只有最后减到0才有相应的组合
        if (target < 0) {
            return;
        }
        // target为0说明搜索到对应的组合，将这条路径加入到结果中，并返回
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        // 这里之前用过的数字不能再用，否则会出现重复的组合
        for (int i = begin; i < len; i++) {
            // 将当前结点添加到路径中
            path.addLast(candidates[i]);
            // 开始搜索，每次从头开始减，因为元素可以重复使用，所以下一轮的起点还是i，target由于做减法，减去当前遍历到的值，最后如果减到0说明找到了对应的组合
            dfs(candidates, i, len, target - candidates[i], path, res);
            // 每找到一个路径，重置状态
            path.removeLast();
        }
    }

}
