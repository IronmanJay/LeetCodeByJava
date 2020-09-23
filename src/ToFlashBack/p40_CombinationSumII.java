package ToFlashBack;

import java.util.*;

public class p40_CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 结果List
        List<List<Integer>> res = new ArrayList<>();
        // 获取数组长度
        int len = candidates.length;
        // 判空返回
        if (len == 0) {
            return res;
        }
        // 路经数组
        Deque<Integer> path = new ArrayDeque<>();
        // 只有进行排序才能去重，且升序
        Arrays.sort(candidates);
        // 开始搜索
        dfs(candidates, res, path, len, target, 0);
        // 返回结果
        return res;
    }

    /**
     * @param candidates 待选数组
     * @param begin      搜索起点
     * @param len        数组长度
     * @param target     目标值，每减一个元素，目标值变小
     * @param path       表示路经
     * @param res        结果集
     */
    public static void dfs(int[] candidates, List<List<Integer>> res, Deque<Integer> path, int len, int target, int begin) {
        // target为负数说明当前搜索失败，没找到对应的组合，因为做减法，只有最后减到0才有相应的组合
        if (target < 0) {
            return;
        }
        // target为0说明搜索到对应的组合，将这条路经加入到结果中，并返回
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 这里之前用过的数字不能再用，否则会出现重复的组合
        for (int i = begin; i < len; i++) {
            // 因为数组升序，当前的元素都不满足条件，后面的肯定更不满足
            if (target - candidates[i] < 0) {
                continue;
            }
            // 这里可以理解为同一层的路径选择，比如[1,2,2,2,5]中，选了第一个2，变成[1,2]，第一个2的下一选项也是2，所以在这里剪枝，因为选它，就还是[1,2]
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 将当前结点添加到路径中
            path.addLast(candidates[i]);
            // 开始搜索，每次从头开始减，因为元素不可以重复使用，所以下一轮的起点是i+1，target由于做减法，减去当前遍历到的值，最后如果减到0说明找到了对应的组合
            dfs(candidates, res, path, len, target - candidates[i], i + 1);
            // 每找到一个路经，重置状态
            path.removeLast();
        }
    }

}
