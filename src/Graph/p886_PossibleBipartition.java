package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class p886_PossibleBipartition {

    public static void main(String[] args) {
        int N = 4;
        int[][] dislikes = {
                {1, 2},
                {1, 3},
                {2, 4},
        };
        boolean res = possibleBipartition(N, dislikes);
        System.out.println("res = " + res);
    }

    // 图的邻接矩阵，都是不喜欢的人构成的邻接矩阵
    private static ArrayList<Integer>[] graph;
    // 染色Map
    private static Map<Integer, Integer> color;

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        // 初始化图的邻接矩阵，从1~N
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        // 表示当前这个人是否被染色，也就是是否被分到了某一组
        color = new HashMap();
        // 遍历每一个人，将其分组，从1~N
        for (int i = 1; i <= N; i++) {
            // 因为要分成两组，所以第二组开始遍历的时候要保证这一组没有被染色
            if (!color.containsKey(i)) {
                // 默认没有染色，开始深度优先搜索，如果不成功直接返回false
                if (!DFS(i, 0)) {
                    return false;
                }
            }
        }
        // 如果成功，返回true
        return true;
    }

    public static boolean DFS(int index, int colorCur) {
        // 递归终止条件，如果当前这个人已经染色，并且要给他染成别的颜色，如果颜色相同，说明两个人不在一组，返回true，如果颜色不同，就是要将互相不喜欢的人分到一个组，返回false
        if (color.containsKey(index)) {
            return color.get(index) == colorCur;
        }
        // 每次递归都将互不喜欢的人置为相反的颜色
        color.put(index, colorCur);
        // 将所有当前结点不喜欢的邻居取出来
        for (int neighbour : graph[index]) {
            // 每次递归都将互不喜欢的人置为相反的颜色（异或运算），判断条件如递归终止条件
            if (!DFS(neighbour, colorCur ^ 1)) {
                return false;
            }
        }
        // 如果成功，返回true
        return true;
    }

}
