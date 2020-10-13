package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class I0401_RouteBetweenNodesLcci {

    public static void main(String[] args) {
        int n = 3;
        int start = 0;
        int target = 2;
        int[][] graph = {
                {0, 1},
                {0, 2},
                {1, 2},
                {1, 2},
        };
        boolean res = findWhetherExistsPath(n, graph, start, target);
        System.out.println("res = " + res);
    }

    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 图的邻接矩阵
        List<List<Integer>> adj = new ArrayList<>();
        // 初始化邻接矩阵
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // 给邻接矩阵赋值
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            adj.get(from).add(to);
        }
        // 开始广度优先搜索
        return BFS(n, adj, start, target);
    }

    public static boolean BFS(int n, List<List<Integer>> adj, int start, int target) {
        // 存储节点的队列，只有没访问过并且不是目标值才加入队列
        Queue<Integer> queue = new LinkedList<>();
        // 起点加入队列
        queue.add(start);
        // 判断节点是否访问过的数组，访问过：true，未访问过：false
        boolean[] visited = new boolean[n];
        // 开始遍历
        while (!queue.isEmpty()) {
            // 出队列
            Integer nodeCur = queue.poll();
            // 当前节点置为访问过
            visited[nodeCur] = true;
            // 遍历当前节点的所有后继节点，如果后继节点就是目标值，返回true，如果后继节点已经访问过，就不能继续使用，跳出当前这次循环，其他节点符合条件加入队列
            for (int i = 0; i < adj.get(nodeCur).size(); i++) {
                Integer nodeSuc = adj.get(nodeCur).get(i);
                if (nodeSuc == target) {
                    return true;
                }
                if (visited[nodeSuc]) {
                    continue;
                }
                queue.add(nodeSuc);
            }
        }
        // 没有找到符合条件的路经，返回false
        return false;
    }

}
