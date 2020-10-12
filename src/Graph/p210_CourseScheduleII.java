package Graph;

import java.util.*;

public class p210_CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2},
        };
        int[] res = findOrder(numCourses, prerequisites);
        System.out.println("res = " + Arrays.toString(res));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        /*结果数组*/
        int[] res = new int[numCourses];
        /*结果数组指针*/
        int index = 0;
        /*表示每个节点入度个数*/
        int[] inDegree = new int[numCourses];
        /*邻接表，表示每个节点的下一个连接节点*/
        List<List<Integer>> adj = new ArrayList<>();
        /*队列存放入度为0的节点，表示当前节点不需要前置课程或者前置课程已经完成*/
        Queue<Integer> queue = new LinkedList<>();
        /*初始化邻接表*/
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        /*给入度数组和邻接表赋值*/
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }
        /*将入度为0的节点入队列*/
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        /*开始遍历*/
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[index++] = cur;
            /*遍历当前节点的所有后继节点，这些节点的入度-1，可以看作此前置课程已经完成，所以后续课程也就没有此限定条件了*/
            for (int c : adj.get(cur)) {
                inDegree[c]--;
                /*如果有某一个后继节点入度为0，说明当前课程的前置课程已经完成，可以继续后面的课程，所以入队列*/
                if (inDegree[c] == 0) {
                    queue.add(c);
                }
            }
        }
        /*最终如果遍历得到的课程数量和题目所给的课程数量不相等，说明所给课程安排不符合要求，返回空数组*/
        if (index != numCourses) {
            return new int[0];
        }
        /*返回结果*/
        return res;
    }

}
